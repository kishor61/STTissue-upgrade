/**
 * 
 */
package com.st.common.service;

import java.util.List;

import com.st.common.model.Area;

/**
 * @author sbora
 *
 */
public interface AreaService {

	/**
	 * @return
	 */
	List<Area> getAreas();

	/**
	 * @param id
	 * @return
	 */
	Area getArea(int id);

	/**
	 * @param area
	 */
	void saveOrUpdate(Area area);

}
