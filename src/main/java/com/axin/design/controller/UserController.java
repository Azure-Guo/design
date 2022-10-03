package com.axin.design.controller;

import com.axin.design.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/suggest")
    public List<String> suggestRequirement(@RequestParam String username) {
        return userService.suggestRequirement(username);
    }
}
