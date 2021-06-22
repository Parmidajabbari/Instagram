package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowProfileController implements Initializable {
    @FXML
    public void setUsername(ActionEvent actionEvent) {
    }
    @FXML
    public void setProfilePhoto(MouseEvent mouseEvent) {
    }
    @FXML
    public void setFollowersCount(ActionEvent actionEvent) {
    }
    @FXML
    public void setPostsCount(ActionEvent actionEvent) {
    }
    @FXML
    public void sendMassage(ActionEvent actionEvent) {
    }
    @FXML
    public void setFollowingsCount(ActionEvent actionEvent) {
    }
    @FXML
    public void setFollowingCondition(ActionEvent actionEvent) {
    }
    @FXML
    public void setBio(ActionEvent actionEvent) {
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

    }

}
