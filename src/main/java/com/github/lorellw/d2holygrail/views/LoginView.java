package com.github.lorellw.d2holygrail.views;

import com.github.lorellw.d2holygrail.entities.User;
import com.github.lorellw.d2holygrail.services.UserService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
@PageTitle("Login")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    @Autowired
    private UserService userService;

    private final LoginForm loginForm = new LoginForm();

    public LoginView(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        loginForm.setAction("login");

        add(new H3("D2R Helper"),loginForm, createRegistrationButton());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }
    }

    private Button createRegistrationButton(){
        Button registrationButton = new Button("Registration");
        registrationButton.addClickListener(event -> new RegistrationDialog(userService).open());
        return registrationButton;
    }

    private static class RegistrationDialog extends Dialog{
        private final TextField usernameTextField = new TextField("Login");
        private final PasswordField passwordField = new PasswordField("Password");
        private final PasswordField confirmPasswordField = new PasswordField("Confirm password");
        private final Button singUpButton = new Button("Sing Up");

        private UserService userService;

        public RegistrationDialog(UserService userService){
            this.userService = userService;
            add(createDialogLayout());
        }

        private VerticalLayout createDialogLayout(){
            configSingUpButton();
            configFields();

            Button closeButton = new Button("Close", e-> this.close());
            HorizontalLayout buttonLayout = new HorizontalLayout(closeButton, singUpButton);

            return new VerticalLayout(usernameTextField, passwordField, confirmPasswordField, buttonLayout);
        }

        private void configSingUpButton(){
            singUpButton.addClickShortcut(Key.ENTER);
            singUpButton.addClickListener(buttonClickEvent -> {
                if (passwordField.getValue().equals(confirmPasswordField.getValue())){
                    if (userService.loadUserByUsername(usernameTextField.getValue()) == null){
                        User user = new User();
                        user.setUsername(usernameTextField.getValue());
                        user.setPassword(passwordField.getValue());
                        userService.addUser(user);
                        this.close();
                    }else {
                        createInfoDialog("Username already exists").open();
                    }
                }else createInfoDialog("Password is not confirmed").open();
            });
        }

        private void configFields(){
            usernameTextField.addValueChangeListener(event -> singUpButton.setEnabled(confirm()));
            passwordField.addValueChangeListener(event -> singUpButton.setEnabled(confirm()));
            confirmPasswordField.addValueChangeListener(event -> singUpButton.setEnabled(confirm()));
        }
        private boolean confirm() {
            return !usernameTextField.isEmpty() && !passwordField.isEmpty() && !confirmPasswordField.isEmpty();
        }

        private Dialog createInfoDialog(String info){
            Dialog infoDialog = new Dialog();

            infoDialog.setHeaderTitle("Message");
            Button cancelButton = new Button("Cancel", e-> infoDialog.close());

            infoDialog.add(info);
            infoDialog.getFooter().add(cancelButton);
            return infoDialog;
        }

    }
}
