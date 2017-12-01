package gamestate;

import javafx.scene.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sathvik on 12/1/17.
 */
public class NullState implements GameState {

    Set<Node> nodes;

    public NullState() {
        nodes = new HashSet<>();
    }

    @Override
    public void tick(long now) {

    }

    @Override
    public Set<Node> getNodes() {
        return nodes;
    }
}
