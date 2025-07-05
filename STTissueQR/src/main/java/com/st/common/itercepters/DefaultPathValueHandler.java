/**
 * 
 */
package com.st.common.itercepters;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.st.common.CommonUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author kishor vaishnav
 * 2025
 *
 */
public class DefaultPathValueHandler implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			request.setAttribute("reelentryurl", CommonUtil.load(CommonUtil.REEL_TEST_ENTRY_PAGE));
			request.setAttribute("rewindentryurl", CommonUtil.load(CommonUtil.REWIND_TEST_ENTRY_PAGE));
			request.setAttribute(CommonUtil.FRP_PROJECTION_PAGE, CommonUtil.load(CommonUtil.FRP_PROJECTION_PAGE));
			request.setAttribute(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE,
					CommonUtil.load(CommonUtil.HOUSE_KEEP_SCHEDULE_PAGE));
			request.setAttribute(CommonUtil.FIBER_PURCHASING_PAGE, CommonUtil.load(CommonUtil.FIBER_PURCHASING_PAGE));
		}

		return true;
	}

}
