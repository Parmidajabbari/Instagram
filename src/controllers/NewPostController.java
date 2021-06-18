package controllers;

import app.Post;
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
import java.net.URL;
import java.util.ResourceBundle;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

public class NewPostController implements Initializable {

    private boolean isSet = false;
    private String caption;

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


    @FXML
    protected void setPhoto(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        String extension = getFileExtension(file.getName());
        if(extension.equals("jpg") || extension.equals("png")) {
            Image image = new Image(file.toURI().toString());
            newPostPhoto.setImage(image);
            isSet = true;
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
