package com.tournament_wizard.TournamentWizard.utils;

import javax.xml.crypto.Data;

public class AuthResponse {
    private String status;
    private String message;
    private String username;

    public AuthResponse(String status, String message, String username) {
        this.status = status;
        this.message = message;
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
