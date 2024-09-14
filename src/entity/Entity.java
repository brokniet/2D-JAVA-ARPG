package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    protected int x;
    protected int y;
    protected int speed;
    public String direction;
    //public BufferedImage image;

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

   // public BufferedImage getImage() {
    //    return image;
    //}

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

   // public void setImage(BufferedImage image) {
  //      this.image = image;
    //}
}
