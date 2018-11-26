package dev.ossy.tilegame.tiles;

import dev.ossy.tilegame.gfx.Assets;

public class GrassTile extends Tile{


    public GrassTile(int id) {
        super(Assets.grassTile, id);
    }

    @Override
    public boolean isSolid(){
        return false;
    }
}
