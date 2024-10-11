package window;

import core.Camera;
import entities.Player;
import game.GameObject;
import input.InputHandler;
import world.GameMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    private final int BIT = 32;
    private final int SCALE = 3;
    private final int TILE_SIZE = BIT * SCALE;

    private ArrayList<GameObject> gameObjects;
    private Player player;
    private InputHandler inputHandler;
    private GameMap gameMap;
    private Camera camera;

    public GamePanel(Player player, InputHandler inputHandler) {
        //refactor a esto, esta declarado en 2 lugares distintos :thinking:
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        this.player = player;
        this.inputHandler = inputHandler;
        this.gameMap = new GameMap(this);
        this.camera = new Camera(player, width, height);
        this.gameObjects = new ArrayList<GameObject>();
        this.gameObjects.add(player);
        this.gameObjects.add(gameMap);
        this.gameObjects.add(camera);

        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }

    public void update() {
        if(inputHandler.actionKeysBeingPressed()) player.update(inputHandler);
        gameObjects.forEach(GameObject::update);
    }

    public void render() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        gameObjects.forEach(gameObject -> gameObject.draw(graphics));
        player.draw(graphics, TILE_SIZE, camera);
        graphics.dispose();
    }

    /*
    this.getHeight() ---> 1057
    this.getWidth() ---> 1920
    this.getHeight()/TILE_SIZE ---> 11
    this.getWidth()/TILE_SIZE ---> 20
     */

    public int getTileSize() {
        return TILE_SIZE;
    }
}
