-- Sample scheduled jobs for dynamic scheduler
-- Insert these records into the scheduled_jobs table

-- Core Production Jobs (Active)
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('scheduledMailAt7_20am', '0 20 7 * * MON-FRI', 'admin@example.com,production@example.com', true),
('scheduledMailAt7_20pm', '0 20 19 * * MON-FRI', 'admin@example.com,production@example.com', true),
('sendTestMailSatSun', '0 0 9 * * SAT,SUN', 'admin@example.com', true);

-- Additional Time-based Jobs (Inactive by default - can be activated as needed)
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('scheduledMailAt8am', '0 0 8 * * MON-FRI', 'admin@example.com', false),
('scheduledMailAt08_00am', '0 0 8 * * MON-FRI', 'admin@example.com', false),
('scheduledMailAt10_30am', '0 30 10 * * MON-FRI', 'admin@example.com', false),
('scheduledMailAt11am', '0 0 11 * * MON-FRI', 'admin@example.com', false),
('getDailyInventeryReportReelAt11_30am', '0 30 11 * * MON-FRI', 'inventory@example.com', false);

-- Weekly and Monthly Jobs
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('scheduledMailWeeklyMon', '0 0 9 * * MON', 'admin@example.com', false),
('scheduledMailMonthly2nd', '0 0 9 2 * *', 'admin@example.com', false),
('gradeandhoursummarymailinamonth', '0 0 9 1 * *', 'reports@example.com', false);

-- Quality Control Jobs
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('qualityTestMailAM', '0 0 8 * * MON-FRI', 'quality@example.com', false),
('qualityTestMailPM', '0 0 20 * * MON-FRI', 'quality@example.com', false),
('coaWeeklyEmailPM5', '0 0 9 * * FRI', 'quality@example.com', false),
('coaWeeklyEmailPM6', '0 0 9 * * FRI', 'quality@example.com', false);

-- KPI and Performance Jobs
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('sendKpiTestMail', '0 0 10 * * MON-FRI', 'kpi@example.com', false);

-- FRP (Fiber Reinforced Plastic) Related Jobs
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('frpproductionopdataentryAM', '0 0 8 * * MON-FRI', 'frp@example.com', false),
('frpopdataentrydetailedreportAM', '0 30 8 * * MON-FRI', 'frp@example.com', false),
('frpdailyopdataentrydetailedreportAM', '0 0 9 * * MON-FRI', 'frp@example.com', false),
('frpproductionopdataentrydetailedreportAM', '0 30 9 * * MON-FRI', 'frp@example.com', false);

-- Inventory and Audit Jobs
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('wetlapInventorySummaryReport', '0 0 10 * * MON-FRI', 'inventory@example.com', false),
('auditisdoneornot', '0 0 17 * * FRI', 'audit@example.com', false),
('docforyoder', '0 0 11 * * MON-FRI', 'docs@example.com', false);

-- Blue Line Logistics Despatch Reports
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('BlueLineLogstcsDespatchReport1', '0 0 8 * * MON-FRI', 'logistics@example.com', false),
('BlueLineLogstcsDespatchReport2', '0 0 12 * * MON-FRI', 'logistics@example.com', false),
('BlueLineLogstcsDespatchReport3', '0 0 16 * * MON-FRI', 'logistics@example.com', false),
('BlueLineLogstcsDespatchReport4', '0 0 20 * * MON-FRI', 'logistics@example.com', false);

-- LA (Logistics Area) Despatch Reports
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('DespatchReportLA1', '0 15 8 * * MON-FRI', 'despatch@example.com', false),
('DespatchReportLA2', '0 15 12 * * MON-FRI', 'despatch@example.com', false),
('DespatchReportLA3', '0 15 16 * * MON-FRI', 'despatch@example.com', false),
('DespatchReportLA24', '0 0 0 * * MON-SUN', 'despatch@example.com', false);

-- Test Email Job
INSERT INTO scheduled_jobs (job_name, cron_expression, email, active) VALUES 
('testEmail', '0 0 12 * * MON-FRI', 'test@example.com', false);

-- Update email addresses with actual ones as needed
-- UPDATE scheduled_jobs SET email = 'your-actual-email@company.com' WHERE job_name IN ('scheduledMailAt7_20am', 'scheduledMailAt7_20pm');

-- Example: Activate specific jobs
-- UPDATE scheduled_jobs SET active = true WHERE job_name IN ('qualityTestMailAM', 'sendKpiTestMail');

-- Example: Update cron expression for a specific job
-- UPDATE scheduled_jobs SET cron_expression = '0 25 7 * * MON-FRI' WHERE job_name = 'scheduledMailAt7_20am';

-- Cron Expression Examples:
-- '0 0 8 * * MON-FRI'     - Every weekday at 8:00 AM
-- '0 30 10 * * *'         - Every day at 10:30 AM
-- '0 0 9 * * MON'         - Every Monday at 9:00 AM
-- '0 0 9 1 * *'           - First day of every month at 9:00 AM
-- '0 0 9 * * SAT,SUN'     - Every Saturday and Sunday at 9:00 AM
-- '0 15 14 * * *'         - Every day at 2:15 PM 