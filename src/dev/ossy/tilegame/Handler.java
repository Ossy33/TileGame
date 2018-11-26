package dev.ossy.tilegame;

import dev.ossy.tilegame.gfx.GameCamera;
import dev.ossy.tilegame.input.KeyManager;
import dev.ossy.tilegame.input.MouseManager;
import dev.ossy.tilegame.worlds.World;

public class Handler {

    private Game game;
    private World world;




    public Handler(Game game){
        this.game = game;
    }

    //GETTERS AND SETTERS

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
