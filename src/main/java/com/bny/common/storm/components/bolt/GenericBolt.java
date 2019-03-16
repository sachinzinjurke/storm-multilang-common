package com.bny.common.storm.components.bolt;

import java.util.ArrayList;
import java.util.List;

import org.apache.storm.topology.BoltDeclarer;

import com.bny.common.storm.components.ComponentConfig;
import com.bny.common.storm.components.grouping.IBoltGrouping;

@SuppressWarnings("rawtypes")
public abstract class GenericBolt extends ComponentConfig implements IBolt {

	protected String componentId;
	protected List<IBoltGrouping> boltGroupings;
	protected Integer parallelismHint;

	public GenericBolt() {
	}

	protected GenericBolt(final String componentId) {
		this.componentId = componentId;
		this.boltGroupings = new ArrayList<IBoltGrouping>();
		this.parallelismHint = null;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setBoltGroupings(final List<IBoltGrouping> boltGroupings) {
		this.boltGroupings = boltGroupings;
	}

	public List<IBoltGrouping> getBoltGroupings() {
		return boltGroupings;
	}

	public void setParallelismHint(final Integer parallelismHint) {
		this.parallelismHint = parallelismHint;
	}

	public Integer getParallelismHint() {
		return parallelismHint;
	}

	public void addBoltGroupingsToBolt(final BoltDeclarer boltDeclarer) {
		for (IBoltGrouping boltGrouping : boltGroupings) {
			boltGrouping.addToBolt(boltDeclarer);
		}
	}
}
