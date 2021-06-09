package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    void login(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("LoginPage");
    }

    @FXML
    void newAccount(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("signupPage1");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
