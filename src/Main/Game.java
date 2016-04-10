package Main;

import Display.Display;
import gfx.Assets;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.State;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    // Properties
    private Display display;
    public String title;
    public int width;
    public int height;
    private boolean running = false;
    private int FPS = 1000;

    // Thread
    private Thread thread;

    // System Variables
    private BufferStrategy bs;
    private Graphics g;

    // States
    private State gameState;
    private State menuState;

    // Input
    private KeyManager keyManager;

    // Constructor
    public Game (String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
    }

    // Initialize
    private void init() {
        GameState.level = "level_2.txt";
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        // Init all the states
        gameState = new GameState(this);
        menuState = new MenuState(this);

        // State the state that we want
        State.setState(gameState);
    }

    private void tick() {
        keyManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        // Clear the screen
        g.clearRect(0, 0, width, height);
        // Draw

        if (State.getState() != null){
            State.getState().render(g);
        }

        // End Draw
        bs.show();
        g.dispose();
    }

    // Main RUN
    public void run() {
        init();

        // Variable for syncing time
        double timePerThick = 1_000_000_000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            // Calculate time diff, ticks and fps
            now = System.nanoTime();
            delta += (now - lastTime) / timePerThick;
            timer += now - lastTime;
            lastTime = now;

            // Call tick and render
            if (delta >= 1) {
             tick();
             render();


             ticks++;
             delta--;
            }

            // Reset and print the FPS
            if (timer >= 1_000_000_000){
                System.out.println("> " + ticks + " FPS / Ticks");
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    // Access keyManager
    public KeyManager getKeyManager(){
        return this.keyManager;
    }

    // Starts the thread
    public synchronized void start() {
        if (running) return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // Stops the thread
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
            System.out.println("Look stop method");
        }
    }
}
