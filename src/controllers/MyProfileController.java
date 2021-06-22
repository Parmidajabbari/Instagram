package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MyProfileController implements Initializable {
    public void setUsername(ActionEvent actionEvent) {
    }

    public void setProfilePhoto(ActionEvent actionEvent) {
    }

    public void setPostsCount(ActionEvent actionEvent) {
    }

    public void setFollowersCount(ActionEvent actionEvent) {
    }

    public void setFollowingsCount(ActionEvent actionEvent) {
    }

    public void editProfile(ActionEvent actionEvent) {
    }

    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
