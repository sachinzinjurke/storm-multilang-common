package com.bny.common.storm.components.grouping;

import org.apache.storm.topology.BoltDeclarer;

public class AllBoltGrouping extends GenericBoltGrouping implements IBoltGrouping {

    public AllBoltGrouping(final String componentId, final String streamId) {
        super(componentId, streamId);
    }

    public AllBoltGrouping(final String componentId) {
        super(componentId);
    }

    public void addToBolt(final BoltDeclarer boltDeclarer) {
           boltDeclarer.allGrouping(componentId);
    }

	
}
