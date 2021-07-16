package com.salesmanager.shop.admin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthenticationSuccessHandler extends AbstractAuthenticatinSuccessHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthenticationSuccessHandler.class);
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }

	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }

		@Override
		protected void redirectAfterSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
			redirectStrategy.sendRedirect(request, response, "/admin/home.html");
			
		}

}
