/**
 * 
 */
package com.st.service.qrt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.entity.qrt.ScheduledJob;
import com.st.repository.qrt.ScheduledJobRepository;

/**
 * 
 */
@Service
public class ScheduledJobService {

	@Autowired
	private ScheduledJobRepository repository;

	public List<ScheduledJob> getAllJobs() {
		return repository.findAll();
	}

	public ScheduledJob saveJob(ScheduledJob job) {
		return repository.save(job);
	}

	public ScheduledJob getJobById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteJobById(Integer id) {
		repository.deleteById(id);
	}

	public Optional<ScheduledJob> findById(Integer id) {
		return repository.findById(id);
	}

	public void delete(ScheduledJob job) {
		repository.delete(job);
	}
}
