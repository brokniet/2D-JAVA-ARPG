package window;

import game.GameLoop;
import input.InputHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private GameLoop gameLoop;
    private InputHandler inputHandler;

    public GamePanel(GameLoop gameLoop, InputHandler inputHandler) {
        this.gameLoop = gameLoop;
        this.inputHandler = inputHandler;
        setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        setFocusable(false);
        setBackground(Color.black);
    }

    @Override
    public void run() {

    }

    /*public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.white);
        graphics.fillRect(100, 100, 500, 500);
        graphics.dispose();
    }*/

}
