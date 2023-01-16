package com.example.C13_S3_demo.filter;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        // get the header from request
        String authHeader=httpServletRequest.getHeader("Authorization");

        ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();

        if(authHeader==null || !authHeader.startsWith("Bearer")){
            //if token is invalid
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            servletOutputStream.print("Missing or Invalid Token");
            servletOutputStream.close();
        }
        else{
            //if token is valid
           String jwtToken= authHeader.substring(7);
           String userName=Jwts.parser().setSigningKey("security key").parseClaimsJws(jwtToken).getBody().getSubject();
           httpServletRequest.setAttribute("firstName",userName);
           filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
