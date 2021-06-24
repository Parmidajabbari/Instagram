package controllers;

import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class DirectPageController implements Initializable {

    @FXML
    private JFXListView<?> directMessages;

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
        PageController.openPage("homePage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // getting a list of followers and followings. each have a name and a button.
    }

}
