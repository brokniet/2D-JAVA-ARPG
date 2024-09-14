package entity;

import input.InputHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void update(InputHandler inputHandler) {
        //movimiento por vector, 8 direcciones
        int dx = 0;
        int dy = 0;

        if(inputHandler.upPressed) {
            System.out.println("up");
            dy -= 1;
        }
        if(inputHandler.downPressed) {
            dy += 1;
        }
        if(inputHandler.leftPressed) {
            dx -= 1;
        }
        if(inputHandler.rightPressed) {
            dx += 1;
        }

        // Normalizar el vector de dirección para mantener la velocidad constante en todas las direcciones
        if (dx != 0 || dy != 0) {
            double length = Math.sqrt(dx * dx + dy * dy);
            dx /= (int) length;
            dy /= (int) length;
        }

        x += dx * speed;
        y += dy * speed;
    }

    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, 50, 50);

    }

}
