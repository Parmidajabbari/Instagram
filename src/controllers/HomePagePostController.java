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
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePagePostController implements Initializable {

    private static int postId;
    public static Post post;

    @FXML
    AnchorPane postPane;

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

    public static void setPost(Post post) {
        HomePagePostController.post = post;
    }

    public static void setPostId(int postId) {
        HomePagePostController.postId = postId;
    }

    @FXML
    public void like(ActionEvent actionEvent) throws IOException {
        postId = HomePageController.getPostId();
        String massage = Tasks.getLikeTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postId));
        Client.sendRequest(massage);
    }

    @FXML
    public void comments(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("commentPage");
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(post != null) {
            Image image = new Image(new ByteArrayInputStream(post.getImageBytes()));
            photo.setImage(image);
            caption.setText(post.getCaption());
            username.setText(post.getOwnerName());
            likesCount.setText(Integer.toString(post.getLikes()));
            commentsCount.setText(Integer.toString(post.getComments()));
            date.setText(post.getUploaded());
        }
    }

}
