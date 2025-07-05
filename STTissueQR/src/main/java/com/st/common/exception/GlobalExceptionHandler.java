/**
 * 
 */
package com.st.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author kishor vaishnav
 * 2025
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ProductionException.class)
	public ModelAndView handleProductionException(HttpServletRequest request, Exception e) {
		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("exception/error_prod_db");
		modelAndView.addObject("exception", e);
		modelAndView.addObject("query", request.getQueryString());
		modelAndView.addObject("url", request.getRequestURL());
		return modelAndView;
	}

	@ExceptionHandler(value = TrackerException.class)
	public ModelAndView handleTrackerException(HttpServletRequest request, Exception e) {

		e.printStackTrace();

		ModelAndView modelAndView = new ModelAndView("exception/error_track_db");

		modelAndView.addObject("exception", e);
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.addObject("query", request.getQueryString());
		return modelAndView;
	}
}
