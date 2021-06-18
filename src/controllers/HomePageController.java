package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    void activity(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("activityPage");
    }

    @FXML
    void direct(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        PageController.closePage(event);
        System.exit(0);
    }

    @FXML
    void home(ActionEvent event) {
    }

    @FXML
    void myProfile(ActionEvent event) {

    }

    @FXML
    void newPost(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("newPost1");
    }

    @FXML
    void search(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("searchPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
