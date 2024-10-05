package game;

import entities.Player;
import input.InputHandler;
import window.GamePanel;
import window.GameWindow;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private GameLoop gameLoop;
    private InputHandler inputHandler;
    private Player player;

    public static void main(String[] args) {
        new Game().start();
    }

    public void start() {
        inputHandler = new InputHandler();
        player = new Player(50, 50, 5);
        gamePanel = new GamePanel(player, inputHandler);
        gameLoop = new GameLoop(inputHandler, gamePanel, player);
        gameWindow = new GameWindow();
        gameWindow.setPanel(gamePanel);
        new Thread(gameLoop).start();
    }

}