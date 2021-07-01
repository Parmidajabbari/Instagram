package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowFollowingsController implements Initializable {

    private static ObservableList<String> list = FXCollections.observableArrayList();

    @FXML
    JFXListView<String> followingsList;

    public static void setList(ObservableList<String> list) {
        ShowFollowingsController.list = list;
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
        String message = Tasks.getShowFollowers(Integer.toString(LoginPageController.getUserId()),
                SearchPageController.getSearch());

        try {
            Client.sendRequest(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        followingsList.setItems(list);
    }
}
