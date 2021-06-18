package controllers;

import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class ThirdSignUpController implements Initializable {

    private String username;

    @FXML
    TextField usernameText;

    @FXML
    JFXTextField resultText;

    @FXML
    public void setUserName(ActionEvent actionEvent) {
        String userNameString = usernameText.getText();
        if(User.isUserAcceptable(userNameString)) {
            username = userNameString;
            resultText.setText("Username saved successfully");
            resultText.setStyle("-fx-text-inner-color: green;");
            FourthSignUpController.setUserName(username);
            usernameText.setEditable(false);
        }
        else if(!User.isUserAcceptable(userNameString)) {
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
        if(!usernameText.isEditable()) {
            PageController.closePage(actionEvent);
            PageController.openPage("signupPage4");
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
