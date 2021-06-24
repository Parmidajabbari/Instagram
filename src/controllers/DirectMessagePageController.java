package controllers;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class DirectMessagePageController implements Initializable {

    @FXML
    private JFXListView<?> messages;

    @FXML
    private Label username;

    @FXML
    private JFXTextField newMessage;

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("directPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.setText("username");
    }

    public void send(ActionEvent actionEvent) {
        String userNewMessage = newMessage.getText();
    }
}
