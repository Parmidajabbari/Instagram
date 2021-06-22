package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowProfileController implements Initializable {
    public void setUsername(ActionEvent actionEvent) {
    }

    public void setProfilePhoto(MouseEvent mouseEvent) {
    }

    public void setFollowersCount(ActionEvent actionEvent) {
    }

    public void setPostsCount(ActionEvent actionEvent) {
    }

    public void sendMassage(ActionEvent actionEvent) {
    }

    public void setFollowingsCount(ActionEvent actionEvent) {
    }

    public void setFollowingCondition(ActionEvent actionEvent) {
    }
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
