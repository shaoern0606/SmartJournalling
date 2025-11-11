package com.example.smart_journal.service;

import com.example.smart_journal.model.User;
import com.example.smart_journal.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public String signup(String email, String name, String password) {
        if (repo.existsById(email)) {
            return "Email already exists!";
        }
        repo.save(new User(email, name, password));
        return "Sign up successful!";
    }

    public String login(String email, String password) {
        User user = repo.findByEmail(email);
        if (user == null) {
            return "Email does not exist!";
        }
        if (!user.getPassword().equals(password)) {
            return "Incorrect password!";
        }
        return "Login successful! Welcome " + user.getDisplayName();
    }
}
