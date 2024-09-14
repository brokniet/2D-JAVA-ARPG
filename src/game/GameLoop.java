package game;

import entity.Player;
import input.InputHandler;
import window.GamePanel;

import java.awt.event.KeyEvent;

public class GameLoop implements Runnable{

    private InputHandler inputHandler;
    private GamePanel gamePanel;
    private Player player;

    public GameLoop(InputHandler inputHandler, GamePanel gamePanel, Player player) {
        this.inputHandler = inputHandler;
        this.gamePanel = gamePanel;
        this.player = player;
    }

    private boolean running;
    private int FPS = 60;
    private double drawInterval = (double) 1000000000 / FPS;

    @Override
    public void run() {
        running = true;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(running) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                render();
                delta--;
            }
        }
    }

    public void update() {
        gamePanel.update();
    }

    public void render() {
        gamePanel.render();
    }
}
