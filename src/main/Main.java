package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Main extends Application {

    private double screenWidth = 800;
    private double screenHeight = 600;




    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, screenWidth, screenHeight);


        stage.setTitle("Overworld Map Test");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
