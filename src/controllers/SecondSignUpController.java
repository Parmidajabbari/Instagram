package controllers;

import app.Client;
import app.Tasks;
import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondSignUpController implements Initializable {

    private static String email;
    private static String username;
    private static String result;
    public static void setEmail(String Email) {
        email = Email;
    }
    public static void setUsername(String Username) {
        username = Username;
    }

    public static void setResult(String result) {
        SecondSignUpController.result = result;
    }

    private static boolean isDone;

    @FXML
    TextField codeText;

    @FXML
    JFXTextField emailText;

    @FXML
    JFXTextField resultText;

    public static void setIsDone(boolean isSet) {
        SecondSignUpController.isDone = isSet;
    }

    @FXML
    public void setCode(ActionEvent actionEvent) throws IOException {
            String userCode = codeText.getText();
            //send userCode to server
            String message = Tasks.getCheckCode(username, email, userCode);
            Client.sendRequest(message);
            if(isDone) {
                FourthSignUpController.setEmail(email);
                codeText.setEditable(false);
            }
    }

    @FXML
    public void nextPage(ActionEvent actionEvent) throws Exception {
        if(!codeText.isEditable()) {
            PageController.closePage(actionEvent);
            PageController.openPage("signupPage4");
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage1");
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailText.setText(email);
    }

}
