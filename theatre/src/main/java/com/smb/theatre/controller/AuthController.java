
package com.smb.theatre.controller;

import com.smb.theatre.model.User;
import com.smb.theatre.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "home"; // This should render home.html from src/main/resources/templates/
    }

    @GetMapping("/register")
    public String showRegistrationForm (Model model) {
        model.addAttribute("user", new User());

        return "register"; // Registration HTML page.
    }

    @PostMapping("/register")
    public String registerUser (@ModelAttribute User user) {
        try {
            userService.create(user);
            return "redirect:/login";
        } catch (Exception e) {
            return "register";
        }
    }

    // Serve the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Return the login HTML page
    }
}
