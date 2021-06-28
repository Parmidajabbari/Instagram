package controllers;

import app.Post;
import app.Tasks;
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

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NewPostController implements Initializable {

    private boolean isSet = false;
    private String caption;
    private Image image;

    @FXML
    ImageView newPostPhoto;

    @FXML
    TextField captionText;

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
            isSet = true;
            String imageString = encodeFileToBase64Binary(file);
            //String massage = Tasks.getNewPostTask();
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
        if(isSet) {
            // Post post = new Post();
            //send post to user
            PageController.closePage(actionEvent);
            PageController.openPage("homePage");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
