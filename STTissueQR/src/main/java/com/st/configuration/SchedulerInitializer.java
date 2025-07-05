/**
 * 
 */
package com.st.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.st.service.qrt.DynamicSchedulerService;

/**
 * kishor vaishnav
 */
@Component
public class SchedulerInitializer implements CommandLineRunner {

    @Autowired
    private DynamicSchedulerService schedulerService;

    @Override
    public void run(String... args) {
        schedulerService.refreshScheduledTasks();
    }
}
