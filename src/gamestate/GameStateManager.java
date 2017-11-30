package gamestate;

import java.util.Stack;

/**
 * Created by Sathvik on 11/30/17.
 */
public class GameStateManager {

    private Stack<GameState> gstack;

    public GameStateManager() {
        gstack = new Stack<>();
    }

    public GameState getState() {
        return gstack.peek();
    }

    public void pushState(GameState gs) {
        gstack.push(gs);
    }

    public void popState() {
        gstack.pop();
    }

    public void setState(GameState gs) {
        popState();
        pushState(gs);
    }
}
