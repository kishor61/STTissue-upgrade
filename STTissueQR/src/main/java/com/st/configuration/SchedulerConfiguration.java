/**
 * 
 */
package com.st.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.st.service.qrt.DynamicSchedulerService;

/**
 * Configuration class for dynamic scheduler
 * @author kishor vaishnav
 */
@Configuration
@EnableScheduling
public class SchedulerConfiguration implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerConfiguration.class);

    @Autowired
    private DynamicSchedulerService dynamicSchedulerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Initializing dynamic scheduler on application startup...");
        try {
            dynamicSchedulerService.refreshScheduledTasks();
            logger.info("Dynamic scheduler initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize dynamic scheduler", e);
        }
    }
} 