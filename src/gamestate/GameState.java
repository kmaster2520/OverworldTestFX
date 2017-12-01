package gamestate;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

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

    /**
     *
     * @return nodes of current game state
     */
    public Set<Node> getNodes();

}
