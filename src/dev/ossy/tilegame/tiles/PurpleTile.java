package dev.ossy.tilegame.tiles;

import dev.ossy.tilegame.gfx.Assets;


public class PurpleTile extends Tile {
    public PurpleTile( int id) {
        super(Assets.purpleTile,id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
