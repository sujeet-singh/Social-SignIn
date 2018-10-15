package com.demo.google.signin.core.servlets;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.google.signin.core.GoogleLoginHelper;

@SlingServlet(paths= {"/bin/store/authcode"})
public class GoogleLoginServlet extends SlingAllMethodsServlet {

	Logger logger = LoggerFactory.getLogger(getClass().getName());
	
	private static final long serialVersionUID = 6772624797547597317L;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		logger.info("******************************");
		String authCode = request.getReader().lines().collect(Collectors.joining());
		String responseStr = GoogleLoginHelper.getProfileDetails(request, authCode);
		response.getWriter().print(responseStr);
	}	
}
