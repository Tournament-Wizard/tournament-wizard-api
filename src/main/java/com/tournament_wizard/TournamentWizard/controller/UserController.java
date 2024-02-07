package com.tournament_wizard.TournamentWizard.controller;

import com.tournament_wizard.TournamentWizard.entity.User;
import com.tournament_wizard.TournamentWizard.service.UserService;
import com.tournament_wizard.TournamentWizard.utils.AuthResponse;
import com.tournament_wizard.TournamentWizard.utils.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Update an existing user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
        // Make sure the user ID in the path and the user ID in the request body match
        if (!userId.equals(user.getId())) {
            throw new IllegalArgumentException("User ID in path and request body must match");
        }
        return userService.saveUser(user);
    }

    // User authentication
    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> userAuthentication(@RequestBody UserCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        Optional<User> authenticatedUser = userService.authenticateUser(username, password);

        if (authenticatedUser.isPresent()) {
            // User is authenticated, generate the authentication response
            User user = authenticatedUser.get();

            // Create the authentication response
            AuthResponse authResponse = new AuthResponse("success", "Login successful", user.getUsername());

            // Return the authentication response
            return ResponseEntity.ok(authResponse);
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse("error", "Invalid credentials", null));
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }
}
