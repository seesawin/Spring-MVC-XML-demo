package com.seesawin.ch03.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = { "/*" })
public class AuthenticationFilter implements Filter {
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (request instanceof ServletRequest && response instanceof ServletResponse) {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;

			System.out.println("do something before servlet...");

			chain.doFilter(request, response);

			System.out.println("do something after servlet...");

		}
	}

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}
}
