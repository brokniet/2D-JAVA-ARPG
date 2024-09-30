package entity;

import graphics.Animation;

import java.awt.*;
import java.util.Map;

public class Entity {

    protected int x;
    protected int y;
    protected int speed;
    public String direction;
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

    public String getDirection() {
        return direction;
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

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
