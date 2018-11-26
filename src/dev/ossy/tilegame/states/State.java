package dev.ossy.tilegame.states;

import dev.ossy.tilegame.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    /**Sets the current state.*/
    public static void setState(State state){
        currentState = state;
    }

    /**Gets the current state.*/
    public static State getState(){
        return currentState;
    }

    //CLASS

    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;

    }

    public abstract void tick();

    public abstract void render(Graphics g);


}
