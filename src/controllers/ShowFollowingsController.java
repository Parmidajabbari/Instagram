package controllers;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowFollowingsController implements Initializable {


    @FXML
    static JFXListView<String> followingsList;

    public static JFXListView<String> getFollowingsList() {
        return followingsList;
    }

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("showProfile");
    }

    @FXML
    void exit(ActionEvent event) {
        PageController.closePage(event);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
