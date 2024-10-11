package entities;

import core.Camera;
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

    public void draw(Graphics2D graphics, int tileSize, Camera camera) {
        /*
        se deberia eliminar la clase Camera? lo unico que hace es setear y devolver los siguientes valores:
        x = player.getX() - (screenWidth / 2);
        y = player.getY() - (screenHeight / 2);
         */
        if(currentAnimation == null) return;
        graphics.drawImage(
                currentAnimation.getCurrentFrame(),
                x - camera.getX() - tileSize / 2,
                y - camera.getY() - tileSize / 2,
                tileSize,
                tileSize,
                null);
    }

    public Map<String, Animation> loadAnimations() {
        AnimationBuilder animationBuilder = new AnimationBuilder("player");
        animationBuilder.setBasicMovement();
        return animationBuilder.build();
    }

}
