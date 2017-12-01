package main;

import gamestate.GameState;
import gamestate.NullState;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Sathvik on 11/30/17.
 */
public class GameStateManager {

    private Stack<GameState> gstack;
    private GameState nullState; // returned when no game states exist
    private boolean stateChanged;

    public GameStateManager() {
        gstack = new Stack<>();
        stateChanged = false;
        nullState = new NullState();
    }

    /**
     *
     * @return current game state
     */
    public GameState current() {
        try {
            return gstack.peek();
        } catch (EmptyStackException e) {
            return nullState;
        }
    }

    /**
     * add new game state on top of existing game state
     * @param gs new game state
     */
    public void push(GameState gs) {
        gstack.push(gs);
        stateChanged = true;
    }

    /**
     * pop current game state
     */
    public void pop() {
        try {
            gstack.pop();
            stateChanged = true;
        } catch (EmptyStackException e) {

        }
    }

    /**
     * replace current game state with new game state
     * @param gs new game state
     */
    public void set(GameState gs) {
        pop();
        push(gs);
        stateChanged = true;
    }

    /**
     *
     * @return whether current game state changed
     */
    public boolean didStateChange() {
        return stateChanged;
    }

    /**
     * called by Main to acknowledge that nodes from old gamestate have been replaced with new nodes
     * GameStateManager class is in the main package to prevent gamestate classes from accessing this method
     */
    protected void ackStateChange() {
        stateChanged = false;
    }
}
