package com.tournament_wizard.TournamentWizard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@Configuration
public class ApiKeyConfig {

    private final JdbcTemplate jdbcTemplate;
    private final List<String> apiKeys;
    @Autowired
    public ApiKeyConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.apiKeys = loadApiKeys();
    }

    private List<String> loadApiKeys(){
        List<String> results = new ArrayList<>();
        String sql = "SELECT id, value FROM api_keys";
        jdbcTemplate.query(sql, rs -> {
            String apiKey = rs.getString("value");
            results.add(apiKey);
        });
        return results;
    }

    public boolean isValidApiKey(String apiKey) {
        return apiKeys.contains(apiKey);
    }

}
