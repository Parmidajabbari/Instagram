package controllers;

import app.Client;
import app.Tasks;
import app.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityPageController implements Initializable {

    @FXML
    void activity(ActionEvent event) {
    }



    @FXML
    void home(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("homePage");
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
    void myProfile(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("myProfile");
    }

    @FXML
    void exit(ActionEvent event) {
        PageController.closePage(event);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String message = Tasks.getNotificationTask(Integer.toString(LoginPageController.getUserId()));
        /*
        try {
            Client.sendRequest(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
