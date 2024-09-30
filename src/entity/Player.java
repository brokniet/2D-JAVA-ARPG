package entity;

import graphics.Animation;
import graphics.AnimationBuilder;
import input.InputHandler;
import window.GamePanel;

import java.awt.*;
import java.util.Map;

public class Player extends Entity {

    public Player(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.animations = loadAnimations();
        setAnimation("walkDown");
    }

    public void update(InputHandler inputHandler) {
        //REFACTOR: Movement class?
        int dx = 0;
        int dy = 0;

        if(inputHandler.upPressed) {
            dy -= 1;
            setAnimation("walkUp");
        }
        if(inputHandler.downPressed) {
            dy += 1;
            setAnimation("walkDown");
        }
        if(inputHandler.leftPressed) {
            dx -= 1;
            setAnimation("walkLeft");
        }
        if(inputHandler.rightPressed) {
            dx += 1;
            setAnimation("walkRight");
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
    }
    public void setAnimation(String key) {
        if(animations.containsKey(key)) {
            currentAnimation = animations.get(key);
        }
    }

    public Map<String, Animation> loadAnimations() {
        AnimationBuilder builder = new AnimationBuilder("player");
        builder.basicMovement();
        return builder.build();
    }

}
