package controllers;

import app.Client;
import app.Post;
import app.Tasks;
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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePagePostController implements Initializable {

    private static int postId;
    private static Post post;

    @FXML
    static AnchorPane showPostPane;

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

    public static AnchorPane getShowPostPane() {
        return showPostPane;
    }

    public static void setPost(Post post) {
        HomePagePostController.post = post;
    }

    public static void setPostId(int postId) {
        HomePagePostController.postId = postId;
    }

    @FXML
    public void like(ActionEvent actionEvent) throws IOException {
        String massage = Tasks.getLikeTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postId));
        Client.sendRequest(massage);
    }

    @FXML
    public void showComments(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("commentPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            photo.setImage(ShowPostController.decodeBase64BinaryToImage(post.getPhotoString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        caption.setText(post.getCaption());
        username.setText(post.getUsername());
        likesCount.setText(Integer.toString(post.getLikesCount()));
        commentsCount.setText(Integer.toString(post.getCommentsCount()));
        date.setText(post.getDateTime());
    }
}
