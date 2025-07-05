/**
 * 
 */
package com.st.entity.qrt;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "scheduled_jobs")
public class ScheduledJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String jobName;
    private String cronExpression;
    private String email;
    
    @Transient
    private String humanReadableCron;
    @Transient
    private LocalDateTime nextExecutionTime;
    private boolean active;
    
}
