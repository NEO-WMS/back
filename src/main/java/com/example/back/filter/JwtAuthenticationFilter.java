package com.example.back.filter;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;


import org.springframework.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.example.back.entity.MemberEntity;
import com.example.back.provider.JwtProvider;
import com.example.back.repository.MemberRepositoy;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    
    private final JwtProvider jwtProvider;
    private final MemberRepositoy memberRepositoy;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            
            String token = parseBearerToken(request);
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String memberId = jwtProvider.validate(token);
            if (memberId == null) {
                filterChain.doFilter(request, response);
                return;
            }

            MemberEntity memberEntity = memberRepositoy.findByMemberId(memberId);
            if (memberEntity == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String role = memberEntity != null ? memberEntity.getMemberRole() : null;

            List<GrantedAuthority> authorities = new ArrayList<>();
            if (role != null) {
                authorities.add(new SimpleGrantedAuthority(role));
            }

            AbstractAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(memberId, null, authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);

            SecurityContextHolder.setContext(securityContext);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        
        String authoization = request.getHeader("Authorization");
        
        boolean hasAuthorization = StringUtils.hasText(authoization);
        if (!hasAuthorization) return null;           
        
        boolean isBearer = authoization.startsWith("Bearer");
        if (!isBearer) return null;
        
        String token = authoization.substring(7);
        return token;
        
    }

}
