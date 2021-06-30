package controllers;

import app.Client;
import app.Tasks;
import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    private static String result;
    private String email;

    private String username;

    private static boolean isDone;

    @FXML
    TextField emailText;

    @FXML
    JFXTextField resultText;

    @FXML
    TextField usernameText;

    public static void setIsDone(boolean isDone) {
        SignUpController.isDone = isDone;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        SignUpController.result = result;
    }

    @FXML
    public void signIn(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("LoginPage");
    }

    @FXML
    public void getEmail(ActionEvent actionEvent) {
        email = emailText.getText();
    }

    @FXML
    public void getUsername(ActionEvent actionEvent) {
        username = usernameText.getText();
        if(!User.isUserAcceptable(username)) {
            switch (User.getUserNameError()) {
                case "invalid" :
                {
                    resultText.setText("Username contains invalid characters");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
                case "length" :
                {
                    resultText.setText("Username length must be between 3 and 20");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
            }
            return;
        }
    }

    @FXML
    public void nextPage(ActionEvent actionEvent) throws Exception {
        //send email and username to server
        String message = Tasks.getSignUpPart1(username, email);
        Client.sendRequest(message);
        resultText.setText(result);
        if(isDone) {
            SecondSignUpController.setEmail(email);
            FourthSignUpController.setUserName(username);
            emailText.setEditable(false);
        }
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
