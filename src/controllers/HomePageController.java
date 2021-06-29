package controllers;

import app.Client;
import app.Tasks;
import app.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    @FXML
    private Label caption;

    @FXML
    private Label likes;

    @FXML
    private Label comments;

    @FXML
    void direct(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("directPage");
    }

    @FXML
    void search(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("searchPage");
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

    @FXML
    public void likePost(ActionEvent actionEvent) {
        // add a like to post if its not liked
    }

    @FXML
    public void comments(ActionEvent actionEvent) throws Exception {
        PageController.openPage("commentPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String message = Tasks.getTimelineTask(Integer.toString(LoginPageController.getUserId()));
        /*
        try {
            Client.sendRequest(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        likes.setText("likes");
        comments.setText("comments");
        caption.setText("caption");
    }


    public void nextPost(ActionEvent actionEvent) {
        // send a request to receive the next post
    }

    public void prevPost(ActionEvent actionEvent) {
        // send a request to receive the previous post
    }
}
