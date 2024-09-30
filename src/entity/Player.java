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
        this.direction = "down";
        loadAnimations();
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
            // REFACTOR: AnimationLoader class? mucha responsabilidad para Player
            // constructor -> this.animations = AnimationLoader.getAnimations();
            BufferedImage walkDown1 = SpriteLoader.loadImage("/player/player-front-1.png");
            BufferedImage walkDown2 = SpriteLoader.loadImage("/player/player-front-2.png");
            BufferedImage walkDown3 = SpriteLoader.loadImage("/player/player-front-3.png");
            Animation walkDownAnimation = new Animation(100); // 100 ms por frame
            walkDownAnimation.addFrame(new Sprite(walkDown1));
            walkDownAnimation.addFrame(new Sprite(walkDown2));
            walkDownAnimation.addFrame(new Sprite(walkDown1));
            walkDownAnimation.addFrame(new Sprite(walkDown3));

            BufferedImage walkUp1 = SpriteLoader.loadImage("/player/player-back-1.png");
            BufferedImage walkUp2 = SpriteLoader.loadImage("/player/player-back-2.png");
            BufferedImage walkUp3 = SpriteLoader.loadImage("/player/player-back-3.png");
            Animation walkUpAnimation = new Animation(100); // 100 ms por frame
            walkUpAnimation.addFrame(new Sprite(walkUp1));
            walkUpAnimation.addFrame(new Sprite(walkUp2));
            walkUpAnimation.addFrame(new Sprite(walkUp1));
            walkUpAnimation.addFrame(new Sprite(walkUp3));

            BufferedImage walkRight1 = SpriteLoader.loadImage("/player/player-right-1.png");
            BufferedImage walkRight2 = SpriteLoader.loadImage("/player/player-right-2.png");
            BufferedImage walkRight3 = SpriteLoader.loadImage("/player/player-right-3.png");
            Animation walkRightAnimation = new Animation(100); // 100 ms por frame
            walkRightAnimation.addFrame(new Sprite(walkRight1));
            walkRightAnimation.addFrame(new Sprite(walkRight2));
            walkRightAnimation.addFrame(new Sprite(walkRight1));
            walkRightAnimation.addFrame(new Sprite(walkRight3));

            BufferedImage walkLeft1 = SpriteLoader.loadImage("/player/player-left-1.png");
            BufferedImage walkLeft2 = SpriteLoader.loadImage("/player/player-left-2.png");
            BufferedImage walkLeft3 = SpriteLoader.loadImage("/player/player-left-3.png");
            Animation walkLeftAnimation = new Animation(100); // 100 ms por frame
            walkLeftAnimation.addFrame(new Sprite(walkLeft1));
            walkLeftAnimation.addFrame(new Sprite(walkLeft2));
            walkLeftAnimation.addFrame(new Sprite(walkLeft1));
            walkLeftAnimation.addFrame(new Sprite(walkLeft3));

            addAnimation("walkDown", walkDownAnimation);
            addAnimation("walkUp", walkUpAnimation);
            addAnimation("walkRight", walkRightAnimation);
            addAnimation("walkLeft", walkLeftAnimation);

            setAnimation("walkDown"); // Establecer la animación inicial
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
