package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchPageController {

    @FXML
     JFXTextField searchText;

    @FXML
    private static JFXTextField resultText;

    public static JFXTextField getResultText() {
        return resultText;
    }

    public static void setResultText(JFXTextField resultText) {
        SearchPageController.resultText = resultText;
    }

    @FXML
    void enterSearch(ActionEvent event) throws IOException {
        String name = searchText.getText();
        String massage = Tasks.getSearchTask(Long.toString(LoginPageController.getUserId()),name);
        //Client.sendRequest(massage);
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
