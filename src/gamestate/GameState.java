package gamestate;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Sathvik on 11/30/17.
 */
public interface GameState {

    /**
     * called every frame
     * @param now current timestamp in nanoseconds
     */
    public void tick(long now);

    default public void handleKeyPress(KeyEvent event) {}

    default public void handleKeyRelease(KeyEvent event) {}

    default public void handleKeyTyped(KeyEvent event) {}

    /**
     *
     * @return nodes of current game state
     */
    public Collection<Node> getNodes();

}
