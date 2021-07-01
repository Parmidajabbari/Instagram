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

public class ShowPostController implements Initializable {

    public static int postId;
    public static Post post;

    public static AnchorPane copyPane;

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

    public static AnchorPane getCopyPane() {
        return copyPane;
    }

    public static void setPost(Post post) {
        ShowPostController.post = post;
    }

    public static void setPostId(int postId) {
        ShowPostController.postId = postId;
    }

    private static Image decodeBase64BinaryToFile(String string) throws Exception{
        String base64Image = string.split(",")[1];
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
        Image image = SwingFXUtils.toFXImage(img, null);
        return image;
    }

    public static Image decodeBase64BinaryToImage(String imageString) {
        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SwingFXUtils.toFXImage(image, null);
    }
    @FXML
    public void like(ActionEvent actionEvent) throws IOException {
        String massage = Tasks.getLikeTask(Integer.toString(LoginPageController.getUserId()),Integer.toString(postId));
        Client.sendRequest(massage);
        copyPane = showPostPane;
    }

    @FXML
    public void showComments(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("commentPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            photo.setImage(decodeBase64BinaryToImage(post.getPhotoString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        caption.setText(post.getCaption());
        username.setText(post.getUsername());
        likesCount.setText(Integer.toString(post.getLikesCount()));
        commentsCount.setText(Integer.toString(post.getCommentsCount()));
        date.setText(post.getDateTime());
        copyPane = showPostPane;
    }
}
