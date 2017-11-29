package main;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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

    private long lastSec;
    private int frameCount;

    private Group root;

    private Node bg;
    private Text text;



    public void tick(long now) {
        if (now - lastSec >= 1000000000) {
            lastSec = now;
            text.setText("FPS: " + frameCount);
            frameCount = 0;
        } else {
            frameCount++;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        root = new Group();
        Scene scene = new Scene(root, screenWidth, screenHeight);

        bg = new Rectangle(screenWidth, screenHeight, Color.BLACK);
        bg.setTranslateX(0);
        bg.setTranslateY(0);
        root.getChildren().add(bg);

        text = new Text("FPS: " + frameCount);
        text.setFill(Color.GREEN);
        text.setTranslateX(100);
        text.setTranslateY(100);
        root.getChildren().add(text);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - prev > tpf) {
                    prev = now;
                } else {
                    return;
                }
                //
                tick(now);
            }
        };
        prev = 0;
        tpf = (long)(1000000000 / fps);
        lastSec = System.nanoTime();
        frameCount = 0;
        timer.start();



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
