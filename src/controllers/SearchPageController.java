package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchPageController {

    @FXML
    private TextField searchedName;

    @FXML
    void activity(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("activityPage");
    }

    @FXML
    void enterSearch(ActionEvent event) {
        String name = searchedName.getText();
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
    void search(ActionEvent event) {
    }

}
