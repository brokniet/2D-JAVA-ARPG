package game;

import input.InputHandler;
import window.GamePanel;
import window.GameWindow;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private GameLoop gameLoop;
    private InputHandler inputHandler;

    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        inputHandler = new InputHandler();
        gameLoop = new GameLoop();
        gamePanel = new GamePanel(gameLoop, inputHandler);
        gameWindow = new GameWindow();
        gameWindow.add(gamePanel);
        new Thread(gamePanel).start();
    }

}