package dev.ossy.tilegame.tiles;

import dev.ossy.tilegame.gfx.Assets;

public class StoneTile extends Tile{

    public StoneTile(int id) {
        super(Assets.stoneTile , id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
