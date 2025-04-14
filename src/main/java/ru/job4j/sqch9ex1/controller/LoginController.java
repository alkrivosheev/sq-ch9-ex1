package ru.job4j.sqch9ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.sqch9ex1.LoginProcessor;

@Controller
public class LoginController {
    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        LoginProcessor lp = new LoginProcessor();
        lp.setUsername(username);
        lp.setPassword(password);

        if(lp.login()) {
            model.addAttribute("message", "You are now logged in!");
        } else {
            model.addAttribute("message", "Login failed!");
        }
        return "login.html";
    }
}
