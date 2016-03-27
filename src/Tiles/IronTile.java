package Tiles;

import gfx.Assets;

public class IronTile extends Tile {
    public IronTile(int id) {
        super(Assets.iron, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
