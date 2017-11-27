package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.PathJoiner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Main extends Application {

    private double screenWidth = 800;
    private double screenHeight = 600;

    private AnimationTimer timer; // game loop
    private double fps = 30; // frames per second
    private long tpf; // time per frame (nanoseconds)
    private long prev; // timestamp of previous frame




    @Override
    public void start(Stage stage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, screenWidth, screenHeight);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - prev < tpf) {
                    return;
                } else {
                    prev = now;
                }
                //

            }
        };
        prev = 0;
        tpf = (long)(1000000000 / fps);
        //timer.start();



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
