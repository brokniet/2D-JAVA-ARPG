package world;

import game.GameObject;
import graphics.Animation;
import graphics.AnimationBuilder;
import graphics.Sprite;
import graphics.SpriteLoader;
import window.GamePanel;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class GameMap implements GameObject {

    private GamePanel gamePanel;
    private int TILE_SIZE;
    private int screenWidth;
    private int screenHeight;
    private int rows;
    private int cols;
    private Animation currentAnimation;
    private Map<String, Animation> animations;

    public GameMap(GamePanel gamePanel) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        this.gamePanel = gamePanel;
        this.TILE_SIZE = gamePanel.getTileSize();
        this.screenWidth = (int) width;
        this.screenHeight = (int) height;
        this.rows = screenHeight / TILE_SIZE;
        this.cols = screenWidth / TILE_SIZE;
        this.animations = loadAnimations();
        setAnimation("basicGrass");
    }

    public void draw(Graphics2D graphics) {
        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows+1; j++) {
                int x = i * TILE_SIZE;
                int y = j * TILE_SIZE;
                graphics.drawImage(currentAnimation.getCurrentFrame(), x, y, TILE_SIZE, TILE_SIZE, null);
            }
        }
    }

    public void update() {
        if(getCurrentAnimation() == null) return;
        getCurrentAnimation().update();
    }

    public Map<String, Animation> loadAnimations() {
        AnimationBuilder animationBuilder = new AnimationBuilder("world");
        animationBuilder.setBasicAnimation("basicGrass", "grass", 2, 500);
        return animationBuilder.build();
    }

    public void setAnimation(String key) {
        if(animations.containsKey(key)) {
            currentAnimation = animations.get(key);
        }
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    /*
    this.getHeight() ---> 1057
    this.getWidth() ---> 1920
    this.getHeight()/TILE_SIZE ---> 11
    this.getWidth()/TILE_SIZE ---> 20
     */

}
