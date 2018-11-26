package dev.ossy.tilegame.states;

import dev.ossy.tilegame.Handler;
import dev.ossy.tilegame.entities.creatures.Player;
import dev.ossy.tilegame.entities.statics.Tree;
import dev.ossy.tilegame.worlds.World;

import java.awt.*;

public class GameState extends State{

    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "res/worlds/world1.tw");
        handler.setWorld(world);

    }
    @Override
    public void tick() {
        world.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
