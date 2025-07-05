/**
 * 
 */
package com.st.common.dao;

import java.util.List;

import com.st.common.model.Area;

/**
 * @author sbora
 *
 */
public interface AreaDao {

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
