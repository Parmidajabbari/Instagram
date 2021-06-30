package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CommentPageController implements Initializable {

    @FXML
    static JFXListView<String> commentsList;

    @FXML
    private JFXTextField newCommentText;

    public static JFXListView<String> getCommentsList() {
        return  commentsList;
    }

    @FXML
    void addNewComment(ActionEvent event) {
        String comment = newCommentText.getText();
        String massage = Tasks.getCommentTask(Integer.toString(LoginPageController.getUserId()),"post id" , comment);
        //Client.sendRequest(massage);

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
