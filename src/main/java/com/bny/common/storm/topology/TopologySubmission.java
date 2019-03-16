package com.bny.common.storm.topology;

import java.util.Map;

import org.apache.storm.Config;
import org.apache.storm.generated.StormTopology;

/**
 * [Class Description]
 *
 * @author Grant Henke
 * @since 12/6/12
 */
public interface TopologySubmission {

    public Map<String, StormTopology> getStormTopologies();

    public void setConfig(final Config config);

    public Config getConfig();

}
