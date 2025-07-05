/**
 * 
 */
package com.st.controller.qrt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.entity.qrt.ScheduledJob;
import com.st.service.qrt.DynamicSchedulerService;
import com.st.service.qrt.ScheduledJobService;

@Controller
@RequestMapping("/JobMonitoring")
public class ScheduledJobController {

	@Autowired
	private ScheduledJobService service;

	@Autowired
	private DynamicSchedulerService dynamicSchedulerService;

	@GetMapping("/refresh")
	public String refreshScheduler(Model model) {
		dynamicSchedulerService.refreshScheduledTasks();
		model.addAttribute("message", "Scheduler refreshed successfully");
		return "redirect:/scheduled-jobs";
	}

	@GetMapping
	public String listJobs(Model model) {
		List<ScheduledJob> jobs = dynamicSchedulerService.findAll(); // Fetch all job data
		// Convert cron expressions to human-readable format
		List<ScheduledJob> jobViewModels = jobs.stream().map(job -> {
			ScheduledJob viewModel = new ScheduledJob();
			viewModel.setId(job.getId());
			viewModel.setJobName(job.getJobName());
			viewModel.setActive(job.isActive());
			viewModel.setEmail(job.getEmail());
			viewModel.setCronExpression(job.getCronExpression());
			// viewModel.setHumanReadableCron(CronExpressionUtils.getHumanReadableCron(job.getCronExpression()));
			return viewModel;
		}).collect(Collectors.toList());

		model.addAttribute("jobs", jobViewModels);
		return "schedular/scheduled-jobs";
	}

	@GetMapping("/add")
	public String addJobForm(Model model) {
		model.addAttribute("job", new ScheduledJob());
		return "schedular/add-job";
	}

	@PostMapping("/save")
	public String saveJob(@ModelAttribute ScheduledJob job, RedirectAttributes redirectAttributes) {

		service.saveJob(job);
		redirectAttributes.addFlashAttribute("message", "Job saved successfully!");

		return "redirect:/JobMonitoring";
	}

	@PostMapping("/editJob")
	public String editJobForm(@ModelAttribute ScheduledJob job, Model model, RedirectAttributes redirectAttributes) {
		ScheduledJob existingJob = service.findById(job.getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid job ID: " + job.getId()));
		existingJob.setJobName(job.getJobName());
		existingJob.setActive(job.isActive());
		existingJob.setEmail(job.getEmail());
		service.saveJob(existingJob);
		redirectAttributes.addFlashAttribute("message", "Job updated successfully!");

		return "redirect:/JobMonitoring";
	}

	@GetMapping("/deleteJob")
	public String deleteJob(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
		ScheduledJob job = service.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid job ID: " + id));
		service.delete(job);
		redirectAttributes.addFlashAttribute("message", "Job deleted successfully!");
		return "redirect:/JobMonitoring";
	}

}
