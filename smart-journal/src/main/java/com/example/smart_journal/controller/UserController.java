package com.example.smart_journal.controller;

import com.example.smart_journal.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String email, @RequestParam String displayName, @RequestParam String password) {
        return service.signup(email, displayName, password);
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return service.login(email, password);
    }

}
