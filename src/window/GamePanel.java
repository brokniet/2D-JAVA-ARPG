package window;

import entity.Player;
import input.InputHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Player player;
    private InputHandler inputHandler;

    public GamePanel(Player player, InputHandler inputHandler) {
        this.player = player;
        this.inputHandler = inputHandler;
        this.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.setBackground(Color.black);
        this.addKeyListener(inputHandler);
        this.setFocusable(true);
        this.requestFocusInWindow(true);
    }

    public void update() {
        player.update(inputHandler);
    }

    public void render() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.black);
        player.draw(graphics);
        graphics.dispose();
    }

}
