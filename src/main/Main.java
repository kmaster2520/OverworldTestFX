package main;

import assets.Assets;
import gamestate.MainState;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Sathvik on 11/27/17.
 */
public class Main extends Application {

    private double screenWidth = 800;
    private double screenHeight = 600;

    // frame control fields
    private AnimationTimer timer; // game loop
    private double fps = 60; // frames per second
    private long tpf; // time per frame (nanoseconds)
    private long prev; // timestamp of previous frame

    private Group root;

    private GameStateManager gsm;



    public void tick(long now) {
        // only if game state changed, replace nodes
        if (gsm.didStateChange()) {
            root.getChildren().clear();
            root.getChildren().addAll(gsm.current().getNodes());
            gsm.ackStateChange();
        }

        gsm.current().tick(now);
    }

    @Override
    public void start(Stage stage) throws Exception {

        root = new Group();
        Scene scene = new Scene(root, screenWidth, screenHeight, Color.BLACK);

        Assets.init();
        System.out.println("done asset init");

        // initialize game state manager
        gsm = new GameStateManager();
        gsm.push(new MainState(gsm, "map1"));

        // set key listeners
        scene.setOnKeyPressed(event -> {
            gsm.current().handleKeyPress(event);
        });
        scene.setOnKeyReleased(event -> {
            gsm.current().handleKeyRelease(event);
        });
        scene.setOnKeyTyped(event -> {
            gsm.current().handleKeyTyped(event);
        });

        // initialize frame timer
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (now - prev >= tpf) {
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
