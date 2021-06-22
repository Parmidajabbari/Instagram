package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    @FXML
    public void changeUsername(ActionEvent actionEvent) {
    }
    @FXML
    public void changeProfilePhoto(ActionEvent actionEvent) {
    }
    @FXML
    public void changeBio(ActionEvent actionEvent) {
    }
    @FXML
    public void done(ActionEvent actionEvent) throws Exception {
        //save changes
        PageController.closePage(actionEvent);
        PageController.openPage("myProfile");
    }

    @FXML
    public void cancel(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("myProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
