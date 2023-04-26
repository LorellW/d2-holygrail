package com.github.lorellw.d2holygrail.config;

import com.github.lorellw.d2holygrail.services.UserService;
import com.github.lorellw.d2holygrail.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends VaadinWebSecurity {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.rememberMe().alwaysRemember(true);

        super.configure(http);

        setLoginView(http, LoginView.class);
    }

}
