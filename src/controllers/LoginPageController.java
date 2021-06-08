package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController implements Initializable {
    @FXML
    public void getUserName(ActionEvent actionEvent) {
    }

    @FXML
    public void getPassword(ActionEvent actionEvent) {
    }

    @FXML
    public void login(ActionEvent actionEvent) {
    }

    @FXML
    public void signUp(ActionEvent actionEvent) {
//        PageController.closePage(actionEvent);
    }
    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(1);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
