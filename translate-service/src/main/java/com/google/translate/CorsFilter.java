package com.google.translate;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

@WebFilter
@Component
public class CorsFilter extends GenericFilterBean {

@SuppressWarnings("unused")
private static final Logger LOGGER=LoggerFactory.getLogger(CorsFilter.class);

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)throws IOException, ServletException {

HttpServletRequest httpServletRequest=(HttpServletRequest) request;
HttpServletResponse httpServletResponse=(HttpServletResponse) response;

httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, X-Requested-With, remember");
httpServletResponse.setHeader("Access-Control-Expose-Headers", "Location");

chain.doFilter(httpServletRequest, httpServletResponse);

}

}
