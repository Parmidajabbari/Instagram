package controllers;

import app.Client;
import app.Tasks;
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

    private String username;
    private String password;
    public static boolean isDone = false;
    public static int userId;

    public static String result = "";

    @FXML
    TextField usernameText;

    @FXML
    TextField passwordText;

    @FXML
    JFXTextField resultText;

    public static void setResult(String result) {
        LoginPageController.result = result;
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        LoginPageController.userId = userId;
    }

    public static void setIsDone(boolean isDone) {
        LoginPageController.isDone = isDone;
    }

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {
        username = usernameText.getText();
        password = passwordText.getText();
        String message = Tasks.getLoginTask(username,password);
        Client.sendRequest(message);
        Thread.sleep(6000);
        resultText.setText(result);
        if(isDone) {
            PageController.closePage(actionEvent);
            PageController.openPage("homePage");
        }
    }

    @FXML
    public void signUp(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage1");
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
