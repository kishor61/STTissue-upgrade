/**
 * 
 */
package com.st.tracker.service;

import java.util.Date;

import com.st.common.exception.TrackerException;

/**
 * @author sbora
 *
 */
public interface BaleInventoryService {
	double getConsumedWetLap(Date sdate,Date edate) throws TrackerException;
}
