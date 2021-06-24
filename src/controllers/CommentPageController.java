package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CommentPageController {

    @FXML
    private JFXTextField newCommentText;

    @FXML
    void addNewComment(ActionEvent event) {
        String comment = newCommentText.getText();

        if(!comment.equals("")) {
            // add the comment and send it to database.
        }

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
    }

}
