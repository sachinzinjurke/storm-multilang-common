package com.bny.common.storm.components.bolt;

import org.apache.storm.topology.IComponent;
import org.apache.storm.topology.TopologyBuilder;

import com.bny.common.storm.components.IComponentConfig;


/**
 * [Class Description]
 *
 * @author Grant Henke
 * @since 12/5/12
 */
public interface IBolt<T extends IComponent> extends IComponentConfig {

    public String getComponentId();

    public T getStormBolt();

    public void addToTopology(final TopologyBuilder builder);

}
