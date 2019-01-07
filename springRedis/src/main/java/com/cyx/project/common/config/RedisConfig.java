package com.cyx.project.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    /*
    是否使用集群
     */
    @Value("${redis.useCluster}")
    private boolean useCluster;

    /*
    redis的服务器地址
     */
    @Value("${redis.host}")
    private String host;

    /*
    redis的服务端口
     */
    @Value("${redis.port}")
    private String port;


}
