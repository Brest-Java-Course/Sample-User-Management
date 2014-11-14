package com.epam.brest.courses.rest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mentee-42 on 14.11.14.
 */
public class OptionsFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.addHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
