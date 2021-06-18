package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    private String email;

    @FXML
    TextField emailText;

    @FXML
    JFXTextField resultText;

    @FXML
    public void enterEmail(ActionEvent actionEvent) throws NullPointerException{
        email = emailText.getText();
        //send email to server
        resultText.setText("Email saved successfully");
        resultText.setStyle("-fx-text-inner-color: green;");
        SecondSignUpController.setEmail(email);
        emailText.setEditable(false);
    }

    @FXML
    public void signIn(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("LoginPage");
    }

    @FXML
    public void nextPage(ActionEvent actionEvent) throws Exception {
        if(!emailText.isEditable()) {
            PageController.closePage(actionEvent);
            PageController.openPage("signupPage2");
        }
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
