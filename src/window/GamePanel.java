package window;

import entities.Player;
import input.InputHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final int BIT = 32;
    private final int SCALE = 3;
    private final int TILE_SIZE = BIT * SCALE;

    private Player player;
    private InputHandler inputHandler;

    public GamePanel(Player player, InputHandler inputHandler) {
        this.player = player;
        this.inputHandler = inputHandler;
        this.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.setBackground(Color.white);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }

    public void update() {
        if(inputHandler.actionKeysBeingPressed()) player.update(inputHandler);

    }

    public void render() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        player.draw(graphics, this);
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
