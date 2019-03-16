package com.bny.common.storm.topology;

import java.util.List;

import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.springframework.beans.factory.FactoryBean;

import com.bny.common.storm.components.bolt.IBolt;
import com.bny.common.storm.components.spouts.ISpout;

/**
 * [Class Description]
 *
 * @author Grant Henke
 * @since 12/3/12
 */
public class TopologyFactory implements FactoryBean<StormTopology> {

    private final List<ISpout> spouts;
    private final List<IBolt> bolts;

    public TopologyFactory(final List<ISpout> spout, final List<IBolt> bolt) {
        this.spouts = spout;
        this.bolts = bolt;
    }

    public StormTopology getObject() throws Exception {
        final TopologyBuilder builder = new TopologyBuilder();

        setTopologySpouts(builder);
        setTopologyBolts(builder);

        return builder.createTopology();
    }

    private void setTopologySpouts(final TopologyBuilder builder) {
        for (ISpout spout : spouts) {
            spout.addToTopology(builder);
        }
    }

    private void setTopologyBolts(final TopologyBuilder builder) {
        for (IBolt bolt : bolts) {
            bolt.addToTopology(builder);
        }
    }

    public Class<?> getObjectType() {
        return StormTopology.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
