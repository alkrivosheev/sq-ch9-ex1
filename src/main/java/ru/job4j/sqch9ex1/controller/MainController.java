package ru.job4j.sqch9ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.sqch9ex1.services.LoggedUserManagementService;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String Logout,
            Model model
    ) {
        if (Logout != null) {
            loggedUserManagementService.setUserName(null);
        }

        String username = loggedUserManagementService.getUserName();

        if (username == null) {
            return "redirect:/";
        }
        return "main.html";
    }
}
