package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ActivityPageController {

    @FXML
    void activity(ActionEvent event) {
    }

    @FXML
    void exit(ActionEvent event) {
        PageController.closePage(event);
        System.exit(0);
    }

    @FXML
    void home(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("homePage");
    }

    @FXML
    void myProfile(ActionEvent event) {

    }

    @FXML
    void newPost(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("searchPage");
    }


}
