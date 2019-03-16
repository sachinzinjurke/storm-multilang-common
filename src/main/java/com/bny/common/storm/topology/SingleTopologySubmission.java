package com.bny.common.storm.topology;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.storm.Config;
import org.apache.storm.generated.StormTopology;

public class SingleTopologySubmission implements TopologySubmission {
	

    private final Map<String, StormTopology> stormTopologies;
    private Config config;
    
    public SingleTopologySubmission(final Map<String, StormTopology> topologyMap) {
        stormTopologies = topologyMap;
        this.config = new Config();
    }

    public SingleTopologySubmission(final String topologyId, final StormTopology stormTopology) {
    	
        stormTopologies = new HashMap<String, StormTopology>();
        stormTopologies.put(topologyId, stormTopology);
        if(MapUtils.isEmpty(config))
        	this.config = new Config();
       // config.registerSerialization(GroupProducts.class);
       // List<String> ports = new ArrayList<String>();
    	//ports.add("6700");
    	//ports.add("6701");
       // config.setMaxSpoutPending(30000);
        //config.setNumWorkers(50);
       // config.setNumAckers(100);
        //config.put(Config.UI_PORT, "8088");
       // config.setMaxTaskParallelism(300);
       // config.setDebug(false);
       // config.put(Config.SUPERVISOR_SLOTS_PORTS, ports);       
        
        
    }

    public Map<String, StormTopology> getStormTopologies() {
        return stormTopologies;
    }

    public void setConfig(final Config config) {
        this.config = config;
    }

    public Config getConfig() {
        return config;
    }
}
