package controllers;

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
    private static boolean isDone;
    private static long userId;

    @FXML
    TextField usernameText;

    @FXML
    TextField passwordText;

    @FXML
    static JFXTextField resultText;

    public static long getUserId() {
        return userId;
    }

    public static void setIsDone(boolean isDone) {
        LoginPageController.isDone = isDone;
    }

    public static JFXTextField getResultText() {
        return resultText;
    }

    public static void setResultText(JFXTextField resultText) {
        LoginPageController.resultText = resultText;
    }

    @FXML
    public void getUserName(ActionEvent actionEvent) {
        username = usernameText.getText();
    }

    @FXML
    public void getPassword(ActionEvent actionEvent) {
        password= passwordText.getText();
    }

    @FXML
    public void login(ActionEvent actionEvent) throws Exception {
        String message = Tasks.getLoginTask(username,password);
        //Client.sendRequest(message);
        //User user;
        //get user from server
        //userId = user.getUserId();
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
