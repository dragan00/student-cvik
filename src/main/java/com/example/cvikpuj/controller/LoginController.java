package com.example.cvikpuj.controller;

import com.example.cvikpuj.Main;
import com.example.cvikpuj.model.Student;
import com.example.cvikpuj.model.Table;
import com.example.cvikpuj.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label errorMsg;

    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    protected void onLogin() throws Exception {
        String username = this.usernameTxt.getText().toString();
        String password = this.passwordTxt.getText().toString();

        if (username.equals("") || password.equals("")){
            this.errorMsg.setText("Morate unijeti sva polja!");
        } else {
            try {
                User user = (User) User.get_by_email(username, password);
                this.errorMsg.setText("");
            Main.showWindow(
                    "menu.fxml",
                    "Izbornik", 600, 215);
            } catch (Exception e) {
                this.errorMsg.setText(e.getMessage());
            }
        }
    }

    @FXML
    protected void openCvik() throws IOException {
        Main.showWindow(
                "cvik.fxml",
                "Cvik", 600, 215);

    }
}