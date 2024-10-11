package entities;

import core.Movement;
import game.GameObject;
import graphics.Animation;

import java.awt.*;
import java.util.Map;

public abstract class Entity implements GameObject {

    protected int x;
    protected int y;
    protected int speed;
    protected Movement movement;
    protected Animation currentAnimation;
    protected Map<String, Animation> animations;

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

    public void setAnimation(String key) {
        if(animations.containsKey(key)) {
            currentAnimation = animations.get(key);
        }
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }
}
