package controllers;

import app.Client;
import app.Tasks;
import app.User;
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

    private static boolean isSet;

    public static void setIsSet(boolean set) {
        isSet = set;
    }

    public static JFXTextField getResultText() {
        return resultText;
    }

    public static void setResultText(JFXTextField resultText) {
        SearchPageController.resultText = resultText;
    }

    @FXML
    void enterSearch(ActionEvent event) throws Exception {
        String name = searchText.getText();
        String massage = Tasks.getSearchTask(Integer.toString(User.getUserId()), name);
        //Client.sendRequest(massage);

        if(isSet) {
            PageController.closePage(event);
            PageController.openPage("showProfile");
        }

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
