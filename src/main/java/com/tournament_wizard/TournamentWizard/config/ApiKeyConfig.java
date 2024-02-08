package com.tournament_wizard.TournamentWizard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class ApiKeyConfig {
    @Value("${api.keys}")
    private String[] apiKeys;

    public enum Permission{
        READ, WRITE, DELETE
    }
    // Map to store API keys and their permissions.
    private Map<String, Set<Permission>> apiKeyPermissions = new HashMap<>();


    public ApiKeyConfig(){
        // Initialize the map with API keys and their permissions.
        // Permission1, permission for admins.
        Set<Permission> permissions1 = new HashSet<>();
        permissions1.add(Permission.READ);
        permissions1.add(Permission.WRITE);
        permissions1.add(Permission.DELETE);

        // Permission2, permission for registered people.
        Set<Permission> permissions2 = new HashSet<>();
        permissions2.add(Permission.READ);
        permissions2.add(Permission.WRITE);

        // Permission3, permission for unregistered people.
        Set<Permission> permissions3 = new HashSet<>();
        permissions3.add(Permission.READ);

        apiKeyPermissions.put("key1", permissions1);
        apiKeyPermissions.put("key2", permissions2);
        apiKeyPermissions.put("key3", permissions3);
    }
    public boolean isValidApiKey(String apiKey) {
        return apiKeyPermissions.containsKey(apiKey);
    }

    public Set<Permission> getPermissionsForApiKey(String apiKey) {
        return apiKeyPermissions.get(apiKey);
    }
}
