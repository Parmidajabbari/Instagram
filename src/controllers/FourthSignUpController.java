package controllers;

import app.Client;
import app.Tasks;
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

    private static String result;

    public static void setEmail(String Email) {
        email = Email;
    }

    public static void setUserName(String UserName) {
        userName = UserName;
    }

    private static boolean isDone;

    @FXML
    TextField passwordText;

    @FXML
    JFXTextField resultText;


    public static void setIsDone(boolean isDone) {
        FourthSignUpController.isDone = isDone;
    }

    public static void setResult(String result) {
        FourthSignUpController.result = result;
    }

    public static boolean isIsDone() {
        return isDone;
    }

    @FXML
    public void completeSignUp(ActionEvent actionEvent) throws Exception {
        password = passwordText.getText();
        if(!User.isPasswordAcceptable(password)) {
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
        }
        else {
            resultText.setText("Password saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            String message = Tasks.getSignUpTask(userName, password, email);
            Client.sendRequest(message);
            Thread.sleep(10000);
            resultText.setText(result);
            if(isDone) {
                PageController.closePage(actionEvent);
                PageController.openPage("homePage");
            }
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage2");
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
