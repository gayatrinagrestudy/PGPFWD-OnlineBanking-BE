package com.simplilearn.capstone.project.config;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.simplilearn.capstone.project.jwt.helper.JwtUtil;
import com.simplilearn.capstone.project.login.service.CustomUserDetailsService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	Environment environment;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		
		//get jwt -> start with Bearer -> validate
		
	
	final String authorizationHeader = request.getHeader(environment.getProperty("authorization.token.header.name"));
	

    String username = null;
    String jwtToken = null;
 
    for(Entry<String, String[]> entry: request.getParameterMap().entrySet()) {
    	 System.out.println(" KEY : VALUE : " +entry.getKey()+" : " +entry.getValue());
    }
   
    
    if (authorizationHeader != null && authorizationHeader.startsWith(environment.getProperty("authorization.token.header.prefix"))) {
    	 jwtToken = authorizationHeader.replace(environment.getProperty("authorization.token.header.prefix"), "");
         username = jwtUtil.extractUsername(jwtToken);
    }

    System.out.println("jwtRequest -------- > " +jwtToken);
	System.out.println("username -------- > " +username);
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
        System.out.println("userDetails -------- > " +userDetails);
        if (jwtUtil.validateToken(jwtToken, userDetails)) {

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            usernamePasswordAuthenticationToken
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            System.out.println("validateToken -------- > " );
        }
    }
    filterChain.doFilter(request, response);
}
	

}
