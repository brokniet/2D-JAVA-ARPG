package models;

import main.Game;

import java.awt.*;

public class Player extends Entity {

    private Game game;

    public Player(Game game, int x, int y) {
        this.game = game;
        setX(x);
        setY(y);
    }

    public void draw(Graphics2D g) {
    }

    public void update() {
    }

}
