package main;

import models.Player;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {

    private final int originalTileSize = 32;
    private final int scale = 2;
    private final int tileSize = originalTileSize * scale;
    //no existen variables para el tamaño de la pantalla, hacen falta? obtener directamente del frame?

    private Thread gameThread;
    private KeyHandler key = new KeyHandler();
    //private Player player;

    int x = 100;
    int y = 100;
    int speed = 4;

    public Game() {
        this.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
        //player = new Player(this, 100, 100);
    }

    @Override
    public void run() {
        int FPS = 60;
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        if(key.upPressed) {
            y -= speed;
        } else if(key.downPressed) {
            y += speed;
        } else if(key.leftPressed) {
            x -= speed;
        } else if(key.rightPressed) {
            x += speed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(x, y, tileSize, tileSize);
        g2.dispose();
    }
}