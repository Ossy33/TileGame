package dev.ossy.tilegame.tiles;

import dev.ossy.tilegame.gfx.Assets;

public class BarrierTile extends Tile {
    public BarrierTile(int id) {
        super(Assets.barrierTile, id);
    }

    public boolean isSolid(){
        return true;
    }
}
