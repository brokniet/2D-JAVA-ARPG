package window;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2D JAVA ARPG");
        setResizable(false);
        setLocationRelativeTo(null);
        setUndecorated(true); // Sin bordes
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizado
    }

    public void setPanel(GamePanel gamePanel) {
        add(gamePanel);
        setVisible(true);
    }

}
