package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PageController {

    public static void closePage(ActionEvent actionEvent) {
        Stage newStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        newStage.close();
    }

    public static void openPage(String name) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(PageController.class.getResource("../pages/" + name + ".fxml"));
        MouseController.handle(root, stage);
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

}
