package com.bny.common.storm.topology;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * [Class Description]
 * 
 * @author Grant Henke
 * @since 12/3/12
 */
public final class TopologySubmitter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TopologySubmitter.class.getSimpleName());
	
	private TopologySubmitter() {
	}

	private static void validateArgs(final String[] args) {
		
		if (args[0] == null) {
			throw new IllegalArgumentException(
					"Argument 1: XmlApplicationContext was not defined");
		}

		/*if (args[1] == null) {
			throw new IllegalArgumentException(
					"Argument 2: TopologySubmission bean was not defined");
		}*/
		/*if (args[2] == null) {
			throw new IllegalArgumentException(
					"Argument 3: TopologyName was not defined");
		}*/
	}

	@SuppressWarnings("unused")
	private static void submitTopologies(final TopologySubmission topologySubmission, String topologyName, int config)throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
		String topoName = topologyName;
		StringTokenizer topology = new StringTokenizer(topologyName, "|");
		if(topologySubmission.getStormTopologies().entrySet().size() > 1){
			if(StringUtils.equals("all", topologyName)){
				for (Map.Entry<String, StormTopology> entry : topologySubmission.getStormTopologies().entrySet()) {
					StormTopology stormTopology = entry.getValue();
					StormSubmitter.submitTopology(entry.getKey(), topologySubmission.getConfig(), stormTopology);
				
				}
			}else{
				while(topology.hasMoreTokens()){
					String currentTopologyName = topology.nextToken();
					StormTopology stormTopology = topologySubmission.getStormTopologies().get(currentTopologyName);
					
					Config topoConfig = topologySubmission.getConfig();
					if(config == 0)
						topoConfig = new Config();
					
					if(stormTopology != null)
						StormSubmitter.submitTopology(currentTopologyName, topoConfig, stormTopology);
				}
			}
		}else{
			for (Map.Entry<String, StormTopology> entry : topologySubmission.getStormTopologies().entrySet()) {
				StormTopology stormTopology = entry.getValue();
				if(topoName == null)
					topoName = entry.getKey();
				Config topoConfig = topologySubmission.getConfig();
				if(config == 0)
					topoConfig = new Config();
				StormSubmitter.submitTopology(topoName, topoConfig, stormTopology);
			}
		}
	}

	@SuppressWarnings("resource")
	public static void main(final String[] args) throws AlreadyAliveException, InvalidTopologyException {
		validateArgs(args);
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(args[0]);
		final TopologySubmission topologySubmission = (TopologySubmission) context.getBean(SingleTopologySubmission.class);
		//final TopologySubmitter topologySubmitter = (TopologySubmitter) context.getBean("clusterTopologySubmitter");
		
		//For the metrics purpose
		/*Config metricsConf = new Config();
		metricsConf.setDebug(true);
		metricsConf.registerMetricsConsumer(LoggingMetricsConsumer.class, 2);*/
		
	    
	    
		try {
			int config = 0;
			if(args.length >2)
				config = Integer.parseInt(args[2]);
			try {
				TopologySubmitter.submitTopologies(topologySubmission, args[1], config);
			} catch (AuthorizationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AlreadyAliveException e) {
			// TODO Auto-generated catch block
			LOGGER.error("error:", e);
		} catch (InvalidTopologyException e) {
			// TODO Auto-generated catch block
			LOGGER.error("error:", e);
		}
	}
}
