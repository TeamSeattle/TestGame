package worlds;

import Tiles.Tile;

import java.awt.*;
import java.io.*;

public class World {

    private static final int WIDTH = 15;
    private static final int HEIGHT = 15;
    private int[][] map;

    public World(String path){
        map = new int[256][256];
        loadWorld(path);
    }

    public void tick(){

    }

    public void render(Graphics g){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                getTile(x,y).render(g,x * 64,y * 64);
            }
        }
    }

    public Tile getTile(int x,int y){
        return Tile.tiles[map[y][x]];
    }

    private void loadWorld(String name){

        File file = new File("res/levels/" + name);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String line;

            int row = 0;
            while ((line = bufferedReader.readLine()) != null) {

                String[] lineCells = line.split(" ");

                for (int cell = 0; cell < lineCells.length; cell++) {
                    int i = Integer.parseInt(lineCells[cell]);
                    map[row][cell] = i;
                }
                row++;
            }

            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    System.out.print(map[x][y] + " ");
                }
                System.out.println("");
            }

        } catch (FileNotFoundException e) {
            System.out.println("World not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something went wrong! Can't load word: " + name);
            e.printStackTrace();
        }
    }
}
