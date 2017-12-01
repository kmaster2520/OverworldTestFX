package gamestate;


import assets.Assets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.GameStateManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Sathvik on 11/30/17.
 */
public class MainState implements GameState {

    private GameStateManager gsm;

    private Set<Node> nodes;
    private Text text;
    private List<ImageView> tiles;

    private long lastSec;
    private int frameCount;

    public MainState(GameStateManager gsm) {
        this.gsm = gsm;
        nodes = new HashSet<>();

        text = new Text("FPS: " + frameCount);
        text.setFill(Color.GREEN);
        text.setTranslateX(400);
        text.setTranslateY(400);
        nodes.add(text);

        tiles = Assets.tileMap("map1").getTileViews();
        nodes.addAll(tiles);
    }

    @Override
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
    public Set<Node> getNodes() {
        return nodes;
    }

}
