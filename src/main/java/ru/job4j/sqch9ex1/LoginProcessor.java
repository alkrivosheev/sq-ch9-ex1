package ru.job4j.sqch9ex1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.job4j.sqch9ex1.services.LoggedUserManagementService;


@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login() {
        String username = this.username;
        String password = this.password;

        boolean loginResult = false;
        if("alex".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUserName(username);
        }
            return loginResult;
    }

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
