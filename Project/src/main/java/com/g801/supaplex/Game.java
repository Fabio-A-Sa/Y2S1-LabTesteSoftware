package com.g801.supaplex;

import com.g801.supaplex.Model.Configuration;
import com.g801.supaplex.Model.Menu.MainMenu;
import com.g801.supaplex.Model.Models.Sprite;
import com.g801.supaplex.Model.Audio.MusicPlayer;
import com.g801.supaplex.States.MenuState;
import com.g801.supaplex.States.State;
import com.g801.supaplex.Viewer.GUI.LanternaGUI;
import com.g801.supaplex.Model.Size;
import java.io.IOException;
import java.util.Stack;

public class Game implements Runnable {

    private final LanternaGUI gui;
    private final Configuration configuration;
    private final Stack<State> states;
    private boolean running = false;
    private Thread thread;

    private synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {

        if (!running)
            return;
        running = false;

        try {
            thread.join(); // joins all threads and waits for them to die
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public Game() throws IOException {
        this.configuration = Configuration.getInstance();
        MusicPlayer musicPlayer = new MusicPlayer("jam_backingTrack.wav");
        musicPlayer.startMusic();

        Integer WIDTH = 150;
        Integer HEIGHT = 50;

        Configuration.setWidth(WIDTH / Sprite.width);
        Configuration.setHeight(HEIGHT / Sprite.height);
        this.gui = new LanternaGUI(new Size(WIDTH, HEIGHT));
        MainMenu mainMenu = new MainMenu();

        states = new Stack<>();
        states.push(new MenuState(mainMenu));
    }

    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 13;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0; // to allow CPU to catch up
        long timer = System.currentTimeMillis();

        while (running) {

            long now = System.nanoTime(); //takes time to load from line 38 to this one

            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                try {
                    tick(lastTime);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                delta--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
            }

        }
        stop();
    }

    private void tick(long time) throws IOException {
        states.peek().step(this, this.gui, time);
    }

    public void pushState(State state) {
        states.push(state);
    }

    public void popState() {
        states.pop();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public static void main(String[] args) throws IOException {
        new Game().start();
    }
}