/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security.jwt;

import com.portfolio.portfolio.security.service.IUserDetailService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author dario
 * valida el token en cada peticion y permite el acceso al recurso, en caso de ser invalido devuelve no autorizado
 */
public class JwtTokenFilter extends OncePerRequestFilter{

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    IUserDetailService userDetailService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     try{
         String token = getToken(request);
         if(token !=null && jwtProvider.validateToken(token)){
             String username = jwtProvider.getUsernameFromToken(token);
             UserDetails userDetails = userDetailService.loadUserByUsername(username);
             UsernamePasswordAuthenticationToken auth =
                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
             SecurityContextHolder.getContext().setAuthentication(auth);
         }
     }catch(Exception e){
         logger.error("fallo el metodo doFilter");
     }
     filterChain.doFilter(request, response);
    }
    
    private String getToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header!=null  && header.startsWith("Bearer"))
            return header.replace("Bearer ","");
         return null;
    }
}
