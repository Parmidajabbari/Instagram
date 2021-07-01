package controllers;

import app.Client;
import app.Tasks;
import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;
import static controllers.NewPostController.getFileExtension;

public class EditProfileController implements Initializable {

    private Image image;
    private String changedUsername;
    private String changedBio;
    private String photoString;
    public static String result = "";

    public static void setResult(String result) {
        EditProfileController.result = result;
    }

    @FXML
    JFXTextField usernameText;
    @FXML
    JFXTextField bioText;
    @FXML
    ImageView profilePhoto;

    @FXML
    JFXTextField resultText;

    public static String getFileExtension(String fullName) {
        checkNotNull(fullName);
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    @FXML
    public void changeProfilePhoto(ActionEvent actionEvent) throws Exception {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        File file = chooser.showOpenDialog(new Stage());
        String extension = getFileExtension(file.getName());
        if(extension.equals("jpg") || extension.equals("png")) {
            image = new Image(file.toURI().toString());
            profilePhoto.setImage(image);
            photoString = NewPostController.encodeFileToBase64Binary(file);

        }
        else {
            return;
        }

    }
    @FXML
    public void logOut(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("mainPage");
    }

    @FXML
    public void done(ActionEvent actionEvent) throws Exception {
        String massage = Tasks.getEditPhoto(Integer.toString(LoginPageController.getUserId()),photoString);
        Client.sendRequest(massage);
        String username = usernameText.getText();
        if(!User.isUserAcceptable(username)) {
            switch (User.getUserNameError()) {
                case "invalid" :
                {
                    resultText.setText("Username contains invalid characters");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
                case "length" :
                {
                    resultText.setText("Username length must be between 3 and 20");
                    resultText.setStyle("-fx-text-inner-color: red;");
                    break;
                }
            }
            return;
        }
        String secondMassage = Tasks.getEditUsername(Integer.toString(LoginPageController.getUserId()),changedUsername);
        Client.sendRequest(secondMassage);
        resultText.setText(result);
        changedBio = bioText.getText();
        String thirdMassage = Tasks.getEditBio(Integer.toString(LoginPageController.getUserId()),changedBio);
        Client.sendRequest(thirdMassage);
        resultText.setText(result);
        PageController.closePage(actionEvent);
        PageController.openPage("myProfile");
    }

    @FXML
    public void cancel(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("myProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get profile photo from server
        //profilePhoto.setImage();
    }

}
