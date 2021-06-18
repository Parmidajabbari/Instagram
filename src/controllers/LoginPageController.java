package controllers;

import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Labeled;
import javafx.scene.input.InputMethodTextRun;

import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {

    private String newPassword;
    private String newEmail;

    @FXML
    TextField username;

    @FXML
    TextField password;

    @FXML
    TextField email;

    @FXML
    JFXTextField resultText;

    @FXML
    public void getUserName(ActionEvent actionEvent) {
        String userName = username.getText();
    }

    @FXML
    public void getEmail(ActionEvent actionEvent) {
        String Email = email.getText();
    }

    @FXML
    public void getPassword(ActionEvent actionEvent) {
        String Password = password.getText();
    }

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("homePage");
    }

    @FXML
    public void signUp(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage1");
    }

    @FXML
    public void setResult(ActionEvent actionEvent) {
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("mainPage");
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
