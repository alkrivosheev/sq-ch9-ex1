package ru.job4j.sqch9ex1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String username = this.username;
        String password = this.password;

        if("alex".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
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
