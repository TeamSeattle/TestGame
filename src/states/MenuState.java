package states;

import Main.Game;
import gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.fillRect(0,0,768,768);
    }
}
