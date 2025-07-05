/**
 * 
 */
package com.st.repository.qrt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.entity.qrt.ScheduledJob;

/**
 * 
 */
@Repository
public interface ScheduledJobRepository extends JpaRepository<ScheduledJob, Integer> {
	
	List<ScheduledJob> findByActiveTrue();
}
