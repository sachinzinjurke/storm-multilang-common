package com.bny.common.storm.components.spouts;

import com.bny.common.storm.components.ComponentConfig;

@SuppressWarnings("rawtypes")
public abstract class GenericSpout extends ComponentConfig implements ISpout {

	protected String componentId;
	protected Integer parallelismHint;

	public GenericSpout(final String componentId) {
		this.componentId = componentId;
		this.parallelismHint = null;
	}

	public GenericSpout() {

	}

	public String getComponentId() {
		return componentId;
	}

	public void setParallelismHint(final Integer parallelismHint) {
		this.parallelismHint = parallelismHint;
	}

	public Integer getParallelismHint() {
		return parallelismHint;
	}

}
