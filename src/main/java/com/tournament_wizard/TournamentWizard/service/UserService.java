package com.tournament_wizard.TournamentWizard.service;


import com.tournament_wizard.TournamentWizard.entity.User;
import com.tournament_wizard.TournamentWizard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Show users
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
