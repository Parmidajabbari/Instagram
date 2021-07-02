package controllers;

import app.Client;
import app.Profile;
import app.Tasks;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowProfileController implements Initializable {

    private static Profile profile;
    private ArrayList<Integer> postIds = new ArrayList<>();
    int index = 0;

    @FXML
    JFXTextField usernameText;
    @FXML
    JFXTextField bioText;
    @FXML
    ImageView profilePhoto;
    @FXML
    TextField postsCountText;
    @FXML
    TextField followersCountText;
    @FXML
    TextField followingsCountText;
    @FXML
    JFXButton follow;
    @FXML
    JFXButton next;
    @FXML
    JFXButton prev;

    public static void setProfile(Profile profile) {
        ShowProfileController.profile = profile;
    }

    @FXML
    public void sendMassage(ActionEvent actionEvent) {
    }
    @FXML
    public void followOrUnfollow(ActionEvent actionEvent) throws IOException, InterruptedException {
        if(follow.getText().equals("Follow")) {
            String massage = Tasks.getFollowTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(SearchPageController.getShowUserId()));
            Client.sendRequest(massage);
            Thread.sleep(2000);
        }
        else {
            String massage = Tasks.getUnFollowTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(SearchPageController.getShowUserId()));
            Client.sendRequest(massage);
            Thread.sleep(2000);
        }
    }
    @FXML
    public void home(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("homePage");
    }

    @FXML
    public void search(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("searchPage");
    }

    @FXML
    public void newPost(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("newPost");
    }

    @FXML
    public void activity(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("activityPage");
    }

    @FXML
    public void myProfile(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("myProfile");
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @FXML
    public void showFollowers(ActionEvent actionEvent) throws Exception {
        PageController.openPage("showFollowersPage");
    }

    @FXML
    public void showFollowings(ActionEvent actionEvent) throws Exception {
        PageController.openPage("showFollowingsPage");
    }

    @FXML
    public void nextPost(ActionEvent actionEvent) throws Exception {
        if(index == postIds.size()-1) {
            next.setVisible(false);
            next.setDisable(true);
        }
        else {
            next.setVisible(true);
            next.setDisable(false);
        }
        String massage = Tasks.getPostViewTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postIds.get(index)));
        Client.sendRequest(massage);
        Thread.sleep(4000);
        PageController.openPage("showPost");
        index++;
    }

    @FXML
    public void prevPost(ActionEvent actionEvent) throws Exception {
        if(index == 0) {
            prev.setVisible(false);
            prev.setDisable(true);
        }
        else  {
            prev.setVisible(true);
            prev.setDisable(false);
        }
        String massage = Tasks.getPostViewTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postIds.get(index)));
        Client.sendRequest(massage);
        Thread.sleep(4000);
        PageController.openPage("showPost");
        index--;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prev.setVisible(false);
        prev.setDisable(true);
        if(profile != null) {
            postIds = profile.getPosts();
            usernameText.setText(profile.getUserName());
            bioText.setText(profile.getBio());
            followersCountText.setText(Integer.toString(profile.getFollowersNumber()));
            followingsCountText.setText(Integer.toString(profile.getFollowingNumber()));
            postsCountText.setText(Integer.toString(profile.getPosts().size()));
            if(profile.isFollowing()) {
                follow.setText("Following");
            }
            else {
                follow.setText("Follow");
            }

        }

    }

}
