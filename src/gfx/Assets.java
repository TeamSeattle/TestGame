package gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH = 64;
    private static final int HEIGHT = 64;

    public static BufferedImage grass;
    public static BufferedImage dirt;
    public static BufferedImage stone;
    public static BufferedImage stone_slabs;
    public static BufferedImage wood;
    public static BufferedImage iron;
    public static BufferedImage cactus;
    public static BufferedImage player;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        grass = sheet.crop(0, 0, WIDTH, HEIGHT);
        dirt = sheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
        stone = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        stone_slabs = sheet.crop(WIDTH * 6, 0, WIDTH, HEIGHT);
        wood = sheet.crop(WIDTH * 4, 0, WIDTH, HEIGHT);
        iron = sheet.crop(WIDTH * 6, HEIGHT, WIDTH, HEIGHT);
        player = sheet.crop(0, HEIGHT * 4, WIDTH, HEIGHT);
        cactus = sheet.crop(WIDTH * 6,HEIGHT * 4,WIDTH,HEIGHT);
    }
}
