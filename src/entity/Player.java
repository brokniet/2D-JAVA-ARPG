package entity;

import core.Movement;
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
        this.movement = new Movement(this);
        this.animations = loadAnimations();
        setAnimation("walkDown");
    }

    public void update(InputHandler inputHandler) {
       movement.movePlayer(inputHandler);
    }

    public void draw(Graphics2D graphics, GamePanel gamePanel) {
        if(currentAnimation != null) {
            graphics.drawImage(currentAnimation.getCurrentFrame(), x, y, gamePanel.getTileSize(), gamePanel.getTileSize(), null);
        }
    }

    public Map<String, Animation> loadAnimations() {
        AnimationBuilder builder = new AnimationBuilder("player");
        builder.basicMovement();
        return builder.build();
    }

}
