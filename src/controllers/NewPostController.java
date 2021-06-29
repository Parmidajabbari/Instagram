package controllers;

import app.Client;
import app.Post;
import app.Tasks;
import com.jfoenix.controls.JFXTextField;
import com.sun.xml.internal.messaging.saaj.util.Base64;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NewPostController implements Initializable {

    private String caption;
    private Image image;
    private String imageString;
    private static int postId;
    private static boolean isPosted = false;

    @FXML
    ImageView newPostPhoto;

    @FXML
    TextField captionText;

    @FXML
    static JFXTextField resultText;

    public static void setPostId(int postId) {
        NewPostController.postId = postId;
    }

    public static void setIsPosted(boolean isPosted) {
        NewPostController.isPosted = isPosted;
    }

    public static JFXTextField getResultText() {
        return resultText;
    }

    public static void setResultText(JFXTextField resultText) {
        NewPostController.resultText = resultText;
    }

    public static String getFileExtension(String fullName) {
        checkNotNull(fullName);
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    private static String encodeFileToBase64Binary(File file) throws Exception{
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);
        return new String(Base64.encode(bytes), "UTF-8");
    }
    @FXML
    protected void setPhoto(ActionEvent event) throws Exception {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        String extension = getFileExtension(file.getName());
        if(extension.equals("jpg") || extension.equals("png")) {
            image = new Image(file.toURI().toString());
            newPostPhoto.setImage(image);

            imageString = encodeFileToBase64Binary(file);
        }
        else {
            return;
        }
    }

    @FXML
    public void setCaption(ActionEvent actionEvent) {
        caption = captionText.getText();
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("homePage");
    }

    @FXML
    public void share(ActionEvent actionEvent) throws Exception {
        String massage = Tasks.getNewPostTask(Integer.toString(LoginPageController.getUserId()),imageString,caption);
        // Client.sendRequest(massage);
        if(isPosted) {
            PageController.closePage(actionEvent);
            PageController.openPage("homePage");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
