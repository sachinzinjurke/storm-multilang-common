package com.bny.common.storm.components.spouts;

import org.apache.storm.topology.IComponent;
import org.apache.storm.topology.TopologyBuilder;

import com.bny.common.storm.components.IComponentConfig;

public interface ISpout<T extends IComponent> extends IComponentConfig {

    public String getComponentId();

    public void addToTopology(final TopologyBuilder builder);

}
