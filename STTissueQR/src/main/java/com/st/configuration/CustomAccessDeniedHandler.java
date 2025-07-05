/**
 * 
 */
package com.st.configuration;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	          System.out.println("access denied");
	        }	 
	        response.sendRedirect(request.getContextPath() + "/accessDenied");		
	}

	}


