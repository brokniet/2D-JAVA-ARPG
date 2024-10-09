package core;

import entities.Player;

public class Camera {

    private Player player;
    private int x;
    private int y;
    private int screenWidth;
    private int screenHeight;

    public Camera(Player player, int screenWidth, int screenHeight) {
        this.player = player;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public void update() {
        x = player.getX() - (screenWidth / 2);
        y = player.getY() - (screenHeight / 2);
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }
}
