package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    void login(ActionEvent event) throws Exception {
       // PageController.closePage(event);
     //   PageController.openPage("loginPage");
    }

    @FXML
    void newAccount(ActionEvent event) throws Exception {
       // PageController.closePage(event);
      //  PageController.openPage("signupPage1");
    }

    @FXML
    public void close(ActionEvent actionEvent) {
//        PageController.closePage(actionEvent);
//        System.exit(1);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
