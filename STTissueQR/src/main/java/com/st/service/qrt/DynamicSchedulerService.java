/**
 * 
 */
package com.st.service.qrt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.st.configuration.JobExecutor;
import com.st.entity.qrt.ScheduledJob;
import com.st.repository.qrt.ScheduledJobRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * kishor vaishnav
 */
@Service
public class DynamicSchedulerService {
	private static final Logger logger = LoggerFactory.getLogger(DynamicSchedulerService.class);
	
    @Autowired
    private ScheduledJobRepository repository;
    
    @Autowired
    private JobExecutor jobExecutor;

    private final ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new HashMap<>();

    public DynamicSchedulerService() {
        taskScheduler.initialize();
    }
    
    // Refresh all tasks
    public void refreshScheduledTasks() {
        // Cancel all existing tasks
    	scheduledTasks.values().forEach(task -> task.cancel(true));
        scheduledTasks.clear();

        // Schedule tasks from the database
        repository.findByActiveTrue().forEach(job -> {
            Runnable task = () -> executeTask(job.getJobName(), job.getEmail());
            try {
                ScheduledFuture<?> future = taskScheduler.schedule(task, new CronTrigger(job.getCronExpression()));
                scheduledTasks.put(job.getJobName(), future);
                logger.info("Scheduled job: {} with cron expression: {}", job.getJobName(), job.getCronExpression());
            } catch (Exception e) {
                logger.error("Failed to schedule job: {} with cron: {}", job.getJobName(), job.getCronExpression(), e);
            }
        });
    }

    // Execute task logic
    private void executeTask(String jobName, String emails) {
    	logger.info("Executing job: {} at {}", jobName, new Date());
    	
    	try {
            switch (jobName) {
            case "scheduled.am":
            case "scheduledMailAt7_20am":
                jobExecutor.scheduledMailAt7_20am(emails);
                break;
                
            case "scheduled.pm":
            case "scheduledMailAt7_20pm":
                jobExecutor.scheduledMailAt7_20pm(emails);
                break;
                
            case "scheduled.mail.test.sat.sun":
            case "sendTestMailSatSun":
                jobExecutor.sendTestMailSatSun(emails);
                break;
                
            case "scheduledMailAt8am":
                jobExecutor.scheduledMailAt8am(emails);
                break;
                
            case "scheduledMailWeeklyMon":
                jobExecutor.scheduledMailWeeklyMon(emails);
                break;
                
            case "scheduledMailAt10_30am":
                jobExecutor.scheduledMailAt10_30am(emails);
                break;
                
            case "getDailyInventeryReportReelAt11_30am":
                jobExecutor.getDailyInventeryReportReelAt11_30am(emails);
                break;
                
            case "scheduledMailAt08_00am":
                jobExecutor.scheduledMailAt08_00am(emails);
                break;
                
            case "scheduledMailAt11am":
                jobExecutor.scheduledMailAt11am(emails);
                break;
                
            case "scheduledMailMonthly2nd":
                jobExecutor.scheduledMailMonthly2nd(emails);
                break;
                
            case "qualityTestMailPM":
                jobExecutor.qualityTestMailPM(emails);
                break;
                
            case "qualityTestMailAM":
                jobExecutor.qualityTestMailAM(emails);
                break;
                
            case "sendKpiTestMail":
                jobExecutor.sendKpiTestMail(emails);
                break;
                
            case "frpproductionopdataentryAM":
                jobExecutor.frpproductionopdataentryAM(emails);
                break;
                
            case "frpopdataentrydetailedreportAM":
                jobExecutor.frpopdataentrydetailedreportAM(emails);
                break;
                
            case "frpdailyopdataentrydetailedreportAM":
                jobExecutor.frpdailyopdataentrydetailedreportAM(emails);
                break;
                
            case "frpproductionopdataentrydetailedreportAM":
                jobExecutor.frpproductionopdataentrydetailedreportAM(emails);
                break;
                
            case "wetlapInventorySummaryReport":
                jobExecutor.wetlapInventorySummaryReport(emails);
                break;
                
            case "auditisdoneornot":
                jobExecutor.auditisdoneornot(emails);
                break;
                
            case "docforyoder":
                jobExecutor.docforyoder(emails);
                break;
                
            case "gradeandhoursummarymailinamonth":
                jobExecutor.gradeandhoursummarymailinamonth(emails);
                break;
                
            case "coaWeeklyEmailPM5":
                jobExecutor.coaWeeklyEmailPM5(emails);
                break;
                
            case "coaWeeklyEmailPM6":
                jobExecutor.coaWeeklyEmailPM6(emails);
                break;
                
            case "BlueLineLogstcsDespatchReport1":
                jobExecutor.BlueLineLogstcsDespatchReport1(emails);
                break;
                
            case "BlueLineLogstcsDespatchReport2":
                jobExecutor.BlueLineLogstcsDespatchReport2(emails);
                break;
                
            case "BlueLineLogstcsDespatchReport3":
                jobExecutor.BlueLineLogstcsDespatchReport3(emails);
                break;
                
            case "BlueLineLogstcsDespatchReport4":
                jobExecutor.BlueLineLogstcsDespatchReport4(emails);
                break;
                
            case "DespatchReportLA1":
                jobExecutor.DespatchReportLA1(emails);
                break;
                
            case "DespatchReportLA2":
                jobExecutor.DespatchReportLA2(emails);
                break;
                
            case "DespatchReportLA3":
                jobExecutor.DespatchReportLA3(emails);
                break;
                
            case "DespatchReportLA24":
                jobExecutor.DespatchReportLA24(emails);
                break;
                
            case "testEmail":
                jobExecutor.testEmail(emails);
                break;

            default:
                logger.warn("Unknown job name: {}", jobName);
                break;
            }
        } catch (Exception e) {
            logger.error("Error executing job: {}", jobName, e);
        }
    }
    
	public List<ScheduledJob> findAll() {
		return repository.findAll();
	}
}
