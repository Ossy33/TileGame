package dev.ossy.tilegame.tiles;

import dev.ossy.tilegame.gfx.Assets;


public class DirtTile extends Tile {

    public DirtTile(int id) {
        super(Assets.dirtTile, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

}
