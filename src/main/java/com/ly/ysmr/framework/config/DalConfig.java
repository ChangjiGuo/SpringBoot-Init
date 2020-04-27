package com.ly.ysmr.framework.config;

import com.ly.dal.datasource.RoutableDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 15:15
 */

@Configuration
public class DalConfig {

    @Primary
    @ConfigurationProperties(prefix = "ysmr.dal.datasource")
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public RoutableDataSource getDataSource() {
        return new RoutableDataSource();
    }
}
