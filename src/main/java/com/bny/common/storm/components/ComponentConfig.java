package com.bny.common.storm.components;

import org.apache.storm.Config;
import org.apache.storm.topology.ComponentConfigurationDeclarer;

public class ComponentConfig implements IComponentConfig {
    protected Config configuration;
    protected Boolean debug;
    protected Integer maxSpoutPending;
    protected Integer maxTaskParallelism;

    protected ComponentConfig() {
        this.configuration = null;
        this.debug = null;
        this.maxSpoutPending = null;
        this.maxTaskParallelism = null;
    }

    public Config getConfiguration() {
        return configuration;
    }

    public void setConfiguration(final Config configuration) {
        this.configuration = configuration;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(final Boolean debug) {
        this.debug = debug;
    }

    public Integer getMaxSpoutPending() {
        return maxSpoutPending;
    }

    public void setMaxSpoutPending(final Integer maxSpoutPending) {
        this.maxSpoutPending = maxSpoutPending;
    }

    public Integer getMaxTaskParallelism() {
        return maxTaskParallelism;
    }

    public void setMaxTaskParallelism(final Integer maxTaskParallelism) {
        this.maxTaskParallelism = maxTaskParallelism;
    }

    @SuppressWarnings("rawtypes")
	protected void addConfigToComponent(final ComponentConfigurationDeclarer componentConfigurationDeclarer) {
        if (configuration != null) {
            componentConfigurationDeclarer.addConfigurations(configuration);
        }
        if (debug != null) {
            componentConfigurationDeclarer.setDebug(debug);
        }
        if (maxSpoutPending != null) {
            componentConfigurationDeclarer.setMaxSpoutPending(maxSpoutPending);
        }
        if (maxTaskParallelism != null) {
            componentConfigurationDeclarer.setMaxTaskParallelism(maxTaskParallelism);
        }
    }
}
