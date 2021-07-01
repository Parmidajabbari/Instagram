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
    private static Post post;

    @FXML
    static AnchorPane copyPane;

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

    public static AnchorPane getCopyPane() {
        return copyPane;
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
        copyPane = postPane;
    }

    @FXML
    public void comments(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("commentPage");
    }
    public static File writeByte(byte[] bytes) {
        File file = new File("");
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(bytes);
            os.close();
        }

        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return file;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        copyPane = new AnchorPane();
        File file = writeByte(post.getImageBytes());
        if(file != null) {
            Image image = new Image(file.toURI().toString());
            photo.setImage(image);
            caption.setText(post.getCaption());
            username.setText(post.getOwnerName());
            likesCount.setText(Integer.toString(post.getLikes()));
            commentsCount.setText(Integer.toString(post.getComments()));
            date.setText(post.getUploaded());
            copyPane = postPane;
        }
    }
}
