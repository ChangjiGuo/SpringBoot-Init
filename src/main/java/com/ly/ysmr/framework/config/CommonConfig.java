package com.ly.ysmr.framework.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * description:
 *
 * @author changji.guo
 * @date 2020/4/26 15:35
 */

@Configuration
@Getter
public class CommonConfig {
    @Value("${ysmr.config.secretCode}")
    private String secretCode;

    @Value("${spring.application.name}")
    private String platform;

    @Value("${ysmr.config.maxSubmitTasks}")
    private int maxSubmitTasks;

    @Value("${ysmr.config.maxMonitorTasks}")
    private int maxMonitorTasks;

    @Value("${ysmr.config.maxCheckTasks}")
    private int maxCheckTasks;

}
