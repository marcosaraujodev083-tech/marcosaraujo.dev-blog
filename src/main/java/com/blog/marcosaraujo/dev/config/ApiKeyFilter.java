package com.blog.marcosaraujo.dev.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_HEADER = "X-API-KEY";

    @Value("${blog.api.secret-key}")
    private String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        // Aplica a validação de segurança apenas para chamadas da API REST (/api/v1/posts)
        if (path.startsWith("/api/")) {
            String requestApiKey = request.getHeader(API_KEY_HEADER);

            if (requestApiKey == null || !requestApiKey.equals(secretKey)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"error\": \"Não autorizado. Informe um cabeçalho X-API-KEY válido.\"}");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}