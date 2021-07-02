package controllers;

import app.Client;
import app.Post;
import app.Tasks;
import com.jfoenix.controls.JFXButton;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowPostController implements Initializable {

    private static int postId;
    private static Post post;

    @FXML
    AnchorPane showPostPane;
    @FXML
    ImageView photo;
    @FXML
    Label caption;
    @FXML
    Label likesCount;
    @FXML
    Label commentsCount;
    @FXML
    Label date;
    @FXML
    Label username;
    @FXML
    JFXButton likeButton;

    public static void setPost(Post post) {
        ShowPostController.post = post;
    }

    public static void setPostId(int postId) {
        ShowPostController.postId = postId;
    }

    public static Post getPost() {
        return post;
    }

    @FXML
    public void like(ActionEvent actionEvent) throws IOException {
        String massage = Tasks.getLikeTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postId));
        Client.sendRequest(massage);
        likeButton.setStyle("-fx-background-color: red;");
    }

    @FXML
    public void showComments(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("commentPage");
    }
    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(post != null) {
            postId = post.getOwnerId();
            Image image = new Image(new ByteArrayInputStream(post.getImageBytes()));
            photo.setImage(image);
            caption.setText(post.getCaption());
            username.setText(post.getOwnerName());
            likesCount.setText(Integer.toString(post.getLikes()));
            commentsCount.setText(Integer.toString(post.getComments()));
            date.setText(post.getUploaded());
            if(post.isLiked()) {
                likeButton.setStyle("-fx-background-color: red;");
            }
        }
    }
}
