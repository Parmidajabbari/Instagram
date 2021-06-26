package app;

import controllers.PageController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PageController.openPage("mainPage");
    }

    public static void main(String[] args) {

        /*
        try {
            Client client = new Client();
            client.setConnection();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        */

        launch(args);
    }

}
