package controllers;

import app.Client;
import app.Tasks;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommentPageController implements Initializable {

    private static ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    JFXListView<String> commentsList;

    @FXML
    private JFXTextField newCommentText;

    public static void setList(ObservableList<String> list) {
        CommentPageController.list = list;
    }

    @FXML
    void addNewComment(ActionEvent event) throws IOException {
        String comment = newCommentText.getText();
        String massage = Tasks.getCommentTask(Integer.toString(LoginPageController.getUserId()),"post id" , comment);
        Client.sendRequest(massage);

    }

    @FXML
    void back(ActionEvent event) throws Exception {
        PageController.closePage(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        commentsList.setItems(list);
    }
}
