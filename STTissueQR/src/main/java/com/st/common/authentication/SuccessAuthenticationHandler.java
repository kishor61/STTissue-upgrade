package com.st.common.authentication;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessAuthenticationHandler implements AuthenticationSuccessHandler {

	private static final Logger log = LoggerFactory.getLogger(SuccessAuthenticationHandler.class);

	@Override
	public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, Authentication authentication)
			throws IOException, jakarta.servlet.ServletException {
		log.info(authentication.getName());
		response.sendRedirect("home");

	}

}
