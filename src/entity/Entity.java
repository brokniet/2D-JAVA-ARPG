package entity;

import core.Movement;
import graphics.Animation;

import java.awt.*;
import java.util.Map;

public abstract class Entity {

    protected int x;
    protected int y;
    protected int speed;
    protected Movement movement;
    protected Animation currentAnimation;
    protected Map<String, Animation> animations;

    public void update() {}

    public void repaint(Graphics2D g) {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAnimation(String key) {
        if(animations.containsKey(key)) {
            currentAnimation = animations.get(key);
        }
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }
}
