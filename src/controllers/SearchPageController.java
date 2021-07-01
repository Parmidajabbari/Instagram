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

    public static String result = "";
    public static String search;
    public static int showUserId;
    @FXML
    JFXTextField searchText;

    @FXML
    JFXTextField resultText;

    public static String getSearch() {
        return search;
    }

    public static void setShowUserId(int showUserId) {
        SearchPageController.showUserId = showUserId;
    }

    public static int getShowUserId() {
        return showUserId;
    }

    public static void setResult(String result) {
        SearchPageController.result = result;
    }

    public static boolean isDone;

    public static void setIsDone(boolean isDone) {
        SearchPageController.isDone = isDone;
    }

    @FXML
    void enterSearch(ActionEvent event) throws Exception {
        String name = searchText.getText();
        search = name;
        String massage = Tasks.getSearchTask(Integer.toString(LoginPageController.getUserId()), name);
        Client.sendRequest(massage);
        resultText.setText(result);

        if(isDone) {
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
