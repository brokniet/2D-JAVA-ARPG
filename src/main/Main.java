package main;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D JAVA ARPG");
        window.pack();
        window.setExtendedState(JFrame.MAXIMIZED_BOTH); //eventualmente cambiar a full screen con GraphicsDevice y GraphicsEnvironment
        window.setVisible(true);

        Game game = new Game();
        window.add(game);
        game.startGameThread();

    }

}
