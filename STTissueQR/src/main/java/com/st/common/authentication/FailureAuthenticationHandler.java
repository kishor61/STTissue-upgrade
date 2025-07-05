package com.st.common.authentication;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class FailureAuthenticationHandler implements AuthenticationFailureHandler {

	 private static final Logger log = LoggerFactory.getLogger(FailureAuthenticationHandler.class);

	@Override
	public void onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, AuthenticationException exception)
			throws IOException, jakarta.servlet.ServletException {
		
		log.info("Authetication fail" + exception.getMessage());
		//response.sendRedirect("signinfail?error=1");

	}

}
