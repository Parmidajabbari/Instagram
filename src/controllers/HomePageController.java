package controllers;

import app.Client;
import app.Tasks;
import app.User;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    private int index = 0;
    private static ArrayList<Integer> postIds = new ArrayList<>();
    @FXML
    JFXButton next;
    @FXML
    JFXButton prev;

    @FXML
    GridPane gridPane;

    @FXML
    AnchorPane anchorPane;

    public static void setPostIds(ArrayList<Integer> postIds) {
        HomePageController.postIds = postIds;
    }

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
    public void nextPost(ActionEvent actionEvent) throws IOException {
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
        anchorPane = HomePagePostController.getCopyPane();
        if(anchorPane == null) {
            System.out.println("sss");
        }
        gridPane.add(anchorPane,0,0);
        index++;
    }

    @FXML
    public void prevPost(ActionEvent actionEvent) throws IOException {
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
        if(anchorPane!= null) {
            anchorPane = HomePagePostController.getCopyPane();
            gridPane.add(anchorPane,0,0);
            index++;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String message = Tasks.getTimelineTask(Integer.toString(LoginPageController.getUserId()));
        try {
            Client.sendRequest(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


}
