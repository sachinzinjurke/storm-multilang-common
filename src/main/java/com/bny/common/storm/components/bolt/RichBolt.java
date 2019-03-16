package com.bny.common.storm.components.bolt;

import org.apache.storm.topology.BoltDeclarer;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.TopologyBuilder;

/**
 * [Class Description]
 *
 * @author Grant Henke
 * @since 12/5/12
 */
public class RichBolt extends GenericBolt {

    private IRichBolt stormBolt;

    public RichBolt(final String componentId, final IRichBolt stormBolt) {
        super(componentId);
        this.stormBolt = stormBolt;
    }

    public IRichBolt getStormBolt() {
        return stormBolt;
    }

    public void addToTopology(final TopologyBuilder builder) {
        BoltDeclarer boltDeclarer;
        if (parallelismHint == null) {
            boltDeclarer = builder.setBolt(componentId, stormBolt);
        } else {
            boltDeclarer = builder.setBolt(componentId, stormBolt, parallelismHint);
        }
        addBoltGroupingsToBolt(boltDeclarer);
        addConfigToComponent(boltDeclarer);
    }
}
