package com.bny.common.storm.components.grouping;

import org.apache.storm.topology.BoltDeclarer;

public class ShuffleBoltGrouping extends GenericBoltGrouping implements IBoltGrouping {

    public ShuffleBoltGrouping(final String componentId, final String streamId) {
        super(componentId, streamId);
    }

    public ShuffleBoltGrouping(final String componentId) {
        super(componentId);
    }

    public void addToBolt(final BoltDeclarer boltDeclarer) {
        if (streamId == null) {
            boltDeclarer.shuffleGrouping(componentId);
        } else {
            boltDeclarer.shuffleGrouping(componentId, streamId);
        }
    }
}
