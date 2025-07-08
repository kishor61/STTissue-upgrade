/**
 * 
 */
package com.st.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.st.common.authentication.FailureAuthenticationHandler;
import com.st.user.service.UserServiceImp;

@Configuration
@ComponentScan
public class SecurityConfig {
	
	private final UserServiceImp userServiceImp;

    public SecurityConfig(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Bean
     UserDetailsService getDetailsService() {
        return userServiceImp;
    }

    @Bean
     DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getDetailsService());
        return daoAuthenticationProvider;
    }

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/STTissueQR", "/", "/login", "/plugins/**", "/dist/**", "/views/**").permitAll()
				.requestMatchers("/home").hasAnyRole("ADMIN", "OPERATOR", "OPERATOR2", "OPERATOR3", "OPERATOR4", "OPERATOR5", "OPERATOR6", "TT")
				.requestMatchers("/report/**").hasAnyRole("ADMIN", "OPERATOR", "OPERATOR2", "OPERATOR3", "OPERATOR4", "OPERATOR6")
				.requestMatchers("/grade/**", "/pm5grade/**").hasAnyRole("ADMIN", "OPERATOR", "OPERATOR6")
				.requestMatchers("/gradetarget/**").hasRole("OPERATOR6")
				.requestMatchers("/deshboard/maildeshboard").hasAnyRole("TT","ADMIN")
				.requestMatchers("/reel/**", "/rewind/**", "/qualitygraph/**").hasAnyRole("ADMIN", "OPERATOR", "OPERATOR4", "OPERATOR6")
				.requestMatchers("/chemicalinv/**", "/utilitykpimaster/**").hasAnyRole("ADMIN", "OPERATOR", "OPERATOR4")	
				.anyRequest().authenticated() // All other requests require authentication
		).formLogin(form -> form
				.loginPage("/login") // Use the custom login page
				.defaultSuccessUrl("/home", true) // Redirect to home after successful login
				.failureUrl("/login?error=true")
				.permitAll() // Allow everyone to see the login page
		).logout(logout -> logout
				.logoutUrl("/signout") // URL for logout
				.logoutSuccessUrl("/")// Redirect to login page after logout
				.deleteCookies("JSESSIONID")
				.permitAll())
		// Frame options to allow embedding for same-origin frames
		.headers(headers -> headers
				.frameOptions(frameOptions -> frameOptions.sameOrigin()))
		.csrf(csrf -> csrf.disable()) // Disable CSRF for development/testing (Enable in
		 .rememberMe(rememberMe -> rememberMe
	                .tokenValiditySeconds(2678400)
	                .userDetailsService(userServiceImp)
	            );											

		return http.build();
	}

	@Bean
	 AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	
	  @Bean AuthenticationFailureHandler customAuthenticationFailureHandler() {
	  return new FailureAuthenticationHandler(); }
	 

}
