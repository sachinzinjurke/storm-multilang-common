package com.bny.common.storm.components;

import org.apache.storm.Config;

/**
 * [Class Description]
 *
 * @author Grant Henke
 * @since 12/5/12
 */
public interface IComponentConfig {

    public Config getConfiguration();

    public void setConfiguration(final Config configuration);

    public Boolean getDebug();

    public void setDebug(final Boolean debug);

    public Integer getMaxSpoutPending();

    public void setMaxSpoutPending(final Integer maxSpoutPending);

    public Integer getMaxTaskParallelism();

    public void setMaxTaskParallelism(final Integer maxTaskParallelism);

}
