package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CommentPageController {

    @FXML
    private JFXTextField newCommentText;

    @FXML
    void addNewComment(ActionEvent event) {
        String comment = newCommentText.getText();
       // String massage = Tasks.getCommentTask(Long.toString(LoginPageController.getUserId()),"post id" , comment);
        //Client.sendRequest(massage);

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
    }

}
