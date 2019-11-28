package com.belong.common.auth.security;

import com.belong.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Token 校验过滤器
 *
 * @author lioncity
 */
public class AuthenticationTokenFilter extends GenericFilterBean {

    /**
     * 携带Token的HTTP头
     */
    public static final String TOKEN_HEADER = "Authorization";

    /**
     * Token工具类
     */
    @Autowired
    private AbstractTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader(TOKEN_HEADER);
        if (authHeader == null || !authHeader.startsWith(AbstractTokenUtil.TOKEN_TYPE_BEARER)) {
            chain.doFilter(httpRequest, response);
            return;
        }
        final String authToken = StringUtils.substring(authHeader, 7);
        String username = StringUtils.isNotBlank(authToken) ? jwtTokenUtil.getUsernameFromToken(authToken) : null;
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null && jwtTokenUtil.validateToken(authToken)) {
            UserDetails userDetails = jwtTokenUtil.getUserDetails(authToken);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(httpRequest, response);
    }
}