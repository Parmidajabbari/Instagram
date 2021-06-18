package controllers;

import app.Post;
import app.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondNewPostController implements Initializable {
    @FXML
    TextField caption;

    public void setCaption() {
        String Caption = caption.getText();
    }
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("newPost1");
    }

    public void share(ActionEvent actionEvent) throws Exception {
        setCaption();
        PageController.closePage(actionEvent);
        PageController.openPage("homePage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
