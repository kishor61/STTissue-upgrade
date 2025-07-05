/**
 * 
 */
package com.st.tracker.dao;

import java.util.Date;

import com.st.common.exception.TrackerException;

/**
 * @author sbora
 *
 */
public interface BaleInventoryDao {
	double getConsumedWetLap(Date sdate,Date edate) throws TrackerException;
}
