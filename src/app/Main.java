package app;

import controllers.PageController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PageController.openPage("mainPage");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
