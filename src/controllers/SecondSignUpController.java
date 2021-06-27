package controllers;

import app.Tasks;
import app.User;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondSignUpController implements Initializable {

    private static String email;
    private static String username;
    public static void setEmail(String Email) {
        email = Email;
    }
    public static void setUsername(String Username) {
        username = Username;
    }
    private static boolean isDone;

    @FXML
    TextField codeText;

    @FXML
    JFXTextField emailText;

    @FXML
    static JFXTextField resultText;

    public static void setIsDone(boolean isSet) {
        SecondSignUpController.isDone = isSet;
    }

    public static JFXTextField getResultText() {
        return resultText;
    }

    public static void setResultText(JFXTextField resultText) {
        SecondSignUpController.resultText = resultText;
    }

    @FXML
    public void setCode(ActionEvent actionEvent) {
            String userCode = codeText.getText();
            //send userCode to server
            String message = Tasks.getCheckCode(username, email, userCode);
            if(isDone) {
                FourthSignUpController.setEmail(email);
                codeText.setEditable(false);
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
