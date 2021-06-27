package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowProfileController implements Initializable {
    private String username;
    private String bio;
    private Image profileImage;
    private int postsCount;
    private int followersCount;
    private int followingsCount;

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
    public void sendMassage(ActionEvent actionEvent) {
    }
    @FXML
    public void followOrUnfollow(ActionEvent actionEvent) {
        if(follow.getText().equals("Follow")) {
//            String massage = Tasks.getUnFollowTask();
//            Client.sendRequest(massage);
        }
        else {
     //       String massage = Tasks.getFollowTask();
//            Client.sendRequest(massage);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get data from server
//        usernameText.setText(username);
//        bioText.setText(bio);
//        profilePhoto.setImage(profileImage);
//        postsCountText.setText(Integer.toString(postsCount));
//        followersCountText.setText(Integer.toString(followersCount));
//        followingsCountText.setText(Integer.toString(followingsCount));
    //        follow.setText("follow/following");
    }

}
