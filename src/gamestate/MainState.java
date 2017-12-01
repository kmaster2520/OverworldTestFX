package gamestate;


import assets.Assets;
import entity.Player;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.GameStateManager;
import map.TileMap;

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

    private Player player;

    private TileMap tileMap;
    private long lastSec;
    private int frameCount;

    public MainState(GameStateManager gsm, String mapName) {
        this.gsm = gsm;
        nodes = new HashSet<>();

        text = new Text("FPS: " + frameCount);
        text.setFill(Color.GREEN);
        text.setTranslateX(400);
        text.setTranslateY(400);
        nodes.add(text);

        tileMap = Assets.tileMap(mapName);
        tiles = tileMap.getTileViews(5, 5);
        nodes.addAll(tiles);

        player = new Player(Assets.playerImage, 500, 500);
        nodes.add(player);


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
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                player.shiftY(-player.getSpeed());
                break;
            case S:
                player.shiftY(player.getSpeed());
                break;
            case A:
                player.shiftX(-player.getSpeed());
                break;
            case D:
                player.shiftX(player.getSpeed());
                break;
            default:
                break;
        }

    }

    @Override
    public void handleKeyRelease(KeyEvent event) {

    }

    @Override
    public Set<Node> getNodes() {
        return nodes;
    }

}
