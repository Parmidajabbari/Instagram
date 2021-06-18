package controllers;

import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class FourthSignUpController implements Initializable {

    private String password;
    private static String userName;
    private static String email;

    public static void setEmail(String Email) {
        email = Email;
    }

    public static void setUserName(String UserName) {
        userName = UserName;
    }

    @FXML
    TextField passwordText;

    @FXML
    JFXTextField resultText;

    @FXML
    public void setPassword(ActionEvent actionEvent) {
        String passwordString = passwordText.getText();
        if(User.isPasswordAcceptable(passwordString)) {
            password = passwordString;
            resultText.setText("Password saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            passwordText.setEditable(false);
        }
        else if(!User.isPasswordAcceptable(passwordString)) {
            switch (User.getPasswordError()) {
                case "invalid" :
                {
                    resultText.setText("Passwords contains invalid characters");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
                case "length" :
                {
                    resultText.setText("Password length must be bigger than 4");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
            }
            return;
        }
    }

    @FXML
    public void completeSignUp(ActionEvent actionEvent) throws Exception {
        if(!passwordText.isEditable()) {
            User newUser = new User(userName,password,email);
            //send user to server
            PageController.closePage(actionEvent);
            PageController.openPage("homePage");
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage3");
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
