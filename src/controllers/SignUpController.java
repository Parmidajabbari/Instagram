package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    private String email;

    private String username;

    @FXML
    TextField emailText;

    @FXML
    JFXTextField resultText;

    @FXML
    TextField usernameText;

    @FXML
    public void signIn(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("LoginPage");
    }

    @FXML
    public void nextPage(ActionEvent actionEvent) throws Exception {
        username = usernameText.getText();
        email = emailText.getText();
        //send email and username to server
        String message = Tasks.getSignUpPart1(username, email);
        //Client.sendRequest(message);
        resultText.setText("Email and Username saved successfully");
        resultText.setStyle("-fx-text-inner-color: green;");
        SecondSignUpController.setEmail(email);
        FourthSignUpController.setUserName(username);
        emailText.setEditable(false);

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
