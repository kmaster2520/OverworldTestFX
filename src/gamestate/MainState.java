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
import util.*;

import java.util.*;

/**
 * Created by Sathvik on 11/30/17.
 */
public class MainState implements GameState {

    private GameStateManager gsm;

    private Set<Node> nodes;
    private Text text;
    private List<ImageView> tiles;

    private Player player;
    private static double playerSpeed = 2;

    private TileMap tileMap;
    private long lastSec;
    private int frameCount;

    private boolean playerUp, playerDown, playerLeft, playerRight;

    public MainState(GameStateManager gsm, String mapName) {
        this.gsm = gsm;
        nodes = new TreeSet<>(Comparators.zComparator);

        text = new Text("FPS: " + frameCount);
        text.setFill(Color.GREEN);
        text.setTranslateX(400);
        text.setTranslateY(400);
        text.setTranslateZ(10);
        nodes.add(text);

        tileMap = Assets.tileMap(mapName);
        tiles = tileMap.getTileViews(0, 0);
        for (ImageView iv : tiles) {
            iv.setTranslateZ(0);
        }
        nodes.addAll(tiles);

        player = new Player(Assets.playerImage, 500, 500);
        player.setTranslateZ(5);
        nodes.add(player);

        playerUp = false;
        playerDown = false;
        playerLeft = false;
        playerRight = false;

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
        //
        if (playerUp)
            player.shiftY(-playerSpeed);
        if (playerDown)
            player.shiftY(playerSpeed);
        if (playerLeft)
            player.shiftX(-playerSpeed);
        if (playerRight)
            player.shiftX(playerSpeed);

    }

    @Override
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                playerUp = true;
                playerDown = false;
                break;
            case S:
                playerUp = false;
                playerDown = true;
                break;
            case A:
                playerLeft = true;
                playerRight = false;
                break;
            case D:
                playerLeft = false;
                playerRight = true;
                break;
            default:
                break;
        }

    }

    @Override
    public void handleKeyRelease(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                playerUp = false;
                break;
            case S:
                playerDown = false;
                break;
            case A:
                playerLeft = false;
                break;
            case D:
                playerRight = false;
                break;
            default:
                break;
        }
    }

    @Override
    public Set<Node> getNodes() {
        return nodes;
    }

}
