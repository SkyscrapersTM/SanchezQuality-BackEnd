package com.sanchezquality.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoints implements AuthenticationEntryPoint{
	
	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoints.class); 

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.error("error en el método commence");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no autorizado");
	}

}
