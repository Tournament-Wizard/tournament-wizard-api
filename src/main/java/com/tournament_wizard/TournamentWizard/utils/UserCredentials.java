package com.tournament_wizard.TournamentWizard.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCredentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
