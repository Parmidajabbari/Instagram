package controllers;

import javafx.event.ActionEvent;

public class SignUpController {
    public void enterEmail(ActionEvent actionEvent) {
    }

    public void nextPage(ActionEvent actionEvent) {
    }

    public void signIn(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) throws Exception {
        PageController.closePage(actionEvent);
        //PageController.openPage("mainPage");
    }

    public void close(ActionEvent actionEvent) {
        PageController.closePage(actionEvent);
        System.exit(1);
    }
}
