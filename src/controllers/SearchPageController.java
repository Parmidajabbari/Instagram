package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchPageController {

    @FXML
    private JFXTextField searchName;

    @FXML
    private JFXTextField searchError;

    @FXML
    void enterSearch(ActionEvent event) {
        String name = searchName.getText();

        // send username to server and get a profile json

        /*
        if(json == null) {
            searchError.setText("No Results Found");
            searchError.setStyle("-fx-text-inner-color: red;");
        }
        else {
            PageController.closePage(event);
            PageController.openPage("showProfile");
        }
        */

    }

    @FXML
    void home(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("homePage");
    }

    @FXML
    void newPost(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("newPost");
    }

    @FXML
    void activity(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("activityPage");
    }

    @FXML
    void myProfile(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("myProfile");
    }

    @FXML
    void exit(ActionEvent event) {
        PageController.closePage(event);
        System.exit(0);
    }

}
