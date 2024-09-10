package window;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("2D JAVA ARPG");
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));

        pack();

        createBufferStrategy(3);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

}
