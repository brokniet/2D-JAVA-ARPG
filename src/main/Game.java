package main;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {

    private final int originalTileSize = 32;
    private final int scale = 2;
    private final int tileSize = originalTileSize * scale;
    private final int FPS = 60;
    //no existen variables para el tamaño de la pantalla, hacen falta? obtener directamente del frame?

    private Thread gameThread;

    public Game() {
        this.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    @Override
    public void run() {
        while(gameThread != null) {
            System.out.println("Thread running.");
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
}
