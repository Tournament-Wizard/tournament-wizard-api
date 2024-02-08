package com.tournament_wizard.TournamentWizard.config;

import com.tournament_wizard.TournamentWizard.config.ApiKeyConfig.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Set;
    @Component
    public class ApiKeyInterceptor implements HandlerInterceptor {
        @Autowired
        private ApiKeyConfig apiKeyConfig;

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            String apiKey = request.getHeader("X-API-Key");

            if (apiKey == null || !apiKeyConfig.isValidApiKey(apiKey)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            // Check permissions based on the API key
            Set<Permission> requiredPermissions = apiKeyConfig.getPermissionsForApiKey(apiKey);
            // Perform permission check logic here
            // For example, you can compare requiredPermissions with the requested endpoint permissions

            return true;
        }
    }

