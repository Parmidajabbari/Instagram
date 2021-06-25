package controllers;

import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondSignUpController implements Initializable {

    private int serverCode = 0;
    private static String email;
    private static String username;
    public static void setEmail(String Email) {
        email = Email;
    }
    public static void setUsername(String Username) {
        username = Username;
    }

    @FXML
    TextField codeText;

    @FXML
    JFXTextField emailText;

    @FXML
    JFXTextField resultText;

    @FXML
    public void setCode(ActionEvent actionEvent) {
        try {
            int userCode = Integer.parseInt(codeText.getText());
            //get serverCode from server
            if(userCode == serverCode) {
                resultText.setText("Email verified successfully");
                resultText.setStyle("-fx-text-inner-color: green;");
                FourthSignUpController.setEmail(email);
                codeText.setEditable(false);
            }
            else {
                resultText.setText("Wrong Code");
                resultText.setStyle("-fx-text-inner-color: red;");
                return;
            }
        }
        catch (NumberFormatException e) {
            resultText.setText("Wrong Code Format");
            resultText.setStyle("-fx-text-inner-color: red;");
            return;
        }
    }

    @FXML
    public void nextPage(ActionEvent actionEvent) throws Exception {
        if(!codeText.isEditable()) {
            PageController.closePage(actionEvent);
            PageController.openPage("signupPage4");
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        PageController.openPage("signupPage1");
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emailText.setText(email);
    }

}
