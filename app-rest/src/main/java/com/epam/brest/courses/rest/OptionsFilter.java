package com.epam.brest.courses.rest;

import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OptionsFilter implements Filter {

    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletResponse.getHeader("Access-Control-Allow-Origin") == null) {
            httpServletResponse.addHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        }
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            httpServletResponse.addHeader("Allow", "GET, POST, PUT, DELETE, OPTIONS");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
