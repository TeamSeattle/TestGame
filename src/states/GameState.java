package states;

import Main.Game;
import entities.creatures.Player;
import worlds.World;

import java.awt.*;

public class GameState extends State {

    public static String level;
    private Player player;
    private World world;

    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World(level);
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
    }

}
