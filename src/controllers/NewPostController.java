package controllers;

import app.Client;
import app.Post;
import app.Tasks;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.ResourceBundle;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NewPostController implements Initializable {

    private String caption;
    private Image image;
    private File file;
    private String imageString = "";
    public static int postId;
    public static boolean isPosted = false;

    public static String result = "";

    @FXML
    ImageView newPostPhoto;

    @FXML
    TextField captionText;

    @FXML
    JFXTextField resultText;

    public static void setResult(String result) {
        NewPostController.result = result;
    }

    public static void setPostId(int postId) {
        NewPostController.postId = postId;
    }

    public static void setIsPosted(boolean isPosted) {
        NewPostController.isPosted = isPosted;
    }

    public static String getFileExtension(String fullName) {
        checkNotNull(fullName);
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
    public static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }

    public static String encodeFileToBase64Binary(File file) throws IOException {
        byte[] fileToByte = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileToByte);
    }
    @FXML
    protected void setPhoto(ActionEvent actionEvent) throws Exception {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        file = chooser.showOpenDialog(new Stage());
        String extension = getFileExtension(file.getName());
        if(extension.equals("jpg") || extension.equals("png")) {
            image = new Image(file.toURI().toString());
            newPostPhoto.setImage(image);
        }
        else {
            return;
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("homePage");
    }

    @FXML
    public void share(ActionEvent actionEvent) throws Exception {
        caption = captionText.getText();
        String massage = Tasks.getNewPostTask(Integer.toString(LoginPageController.getUserId()),caption);
        Client.sendRequest(massage);
        Thread.sleep(1000);
        Client.sendMessage(Files.readAllBytes(file.toPath()));
        Thread.sleep(8000);
        resultText.setText(result);
        if(isPosted) {
            PageController.closePage(actionEvent);
            PageController.openPage("homePage");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
