package window;

import core.Camera;
import entities.Player;
import input.InputHandler;
import world.GameMap;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int BIT = 32;
    private final int SCALE = 3;
    private final int TILE_SIZE = BIT * SCALE;

    private Player player;
    private InputHandler inputHandler;
    private GameMap gameMap;
    private Camera camera;

    public GamePanel(Player player, InputHandler inputHandler) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        this.player = player;
        this.inputHandler = inputHandler;
        this.gameMap = new GameMap(this);
        this.camera = new Camera(player, width, height);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }

    public void update() {
        //eventualmente hacer forEach para todas las entidades asi se updatean
        if(inputHandler.actionKeysBeingPressed()) player.update(inputHandler);
        gameMap.update();
        camera.update();
    }

    public void render() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        //eventualmente hacer forEach para todas las entidades asi se pintan
        gameMap.draw(graphics);
        player.draw(graphics, this, camera);
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
