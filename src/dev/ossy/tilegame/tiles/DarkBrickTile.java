package dev.ossy.tilegame.tiles;


import dev.ossy.tilegame.gfx.Assets;

public class DarkBrickTile extends Tile {

    public DarkBrickTile(int id) {
        super(Assets.darkBrickTile, id);
    }

    public boolean isSolid(){
        return true;
    }
}
