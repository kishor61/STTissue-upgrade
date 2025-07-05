/**
 * 
 */
package com.st.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.st.common.dao.AreaDao;
import com.st.common.model.Area;

/**
 * @author sbora
 *
 */
@Service
public class AreaServiceImp implements AreaService {

	@Autowired
	private AreaDao areaDao;
	/* (non-Javadoc)
	 * @see com.st.common.service.AreaService#getAreas()
	 */
	@Transactional
	@Override
	public List<Area> getAreas() {
		return areaDao.getAreas();
	}
	/* (non-Javadoc)
	 * @see com.st.common.service.AreaService#getArea(int)
	 */
	@Transactional
	@Override
	public Area getArea(int id) {
		
		return areaDao.getArea(id);
	}
	/* (non-Javadoc)
	 * @see com.st.common.service.AreaService#saveOrUpdate(com.st.common.model.Area)
	 */
	@Transactional
	@Override
	public void saveOrUpdate(Area area) {
		areaDao.saveOrUpdate(area);
	}

}
