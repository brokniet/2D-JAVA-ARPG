package entity;

import graphics.Animation;
import graphics.Sprite;
import graphics.SpriteLoader;
import input.InputHandler;
import window.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class Player extends Entity {

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.animations = new HashMap<>();
        loadAnimations();
        /*try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/test3.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    public void update(InputHandler inputHandler) {
        int dx = 0;
        int dy = 0;

        if(inputHandler.upPressed) {
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

        if(currentAnimation != null) currentAnimation.update();
    }

    public void draw(Graphics2D graphics, GamePanel gamePanel) {
        if(currentAnimation != null) {
            graphics.drawImage(currentAnimation.getCurrentFrame(), x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
        //graphics.drawImage(image, x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);

    }

    public void addAnimation(String key, Animation animation) {
        animations.put(key, animation);
    }

    public void setAnimation(String key) {
        if(animations.containsKey(key)) {
            currentAnimation = animations.get(key);
        }
    }

    public void loadAnimations() {
        try {
            BufferedImage walk1 = SpriteLoader.loadImage("/player/test3.png");
            Animation walkAnimation = new Animation(100); // 100 ms por frame
            walkAnimation.addFrame(new Sprite(walk1));

            addAnimation("walk", walkAnimation);
            setAnimation("walk"); // Establecer la animación inicial
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
