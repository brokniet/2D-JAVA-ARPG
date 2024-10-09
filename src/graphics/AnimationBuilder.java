package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnimationBuilder {

    private Map<String, Animation> animations;
    private String resourceName;
    private SpriteLoader spriteLoader;

    public AnimationBuilder(String resourceName) {
         this.animations = new HashMap<>();
         this.resourceName = resourceName;
         this.spriteLoader = SpriteLoader.getInstance();
    }

    public void setBasicMovement() {
        addAnimation("walkDown", getMovementAnimation("front"));
        addAnimation("walkUp", getMovementAnimation("back"));
        addAnimation("walkRight", getMovementAnimation("right"));
        addAnimation("walkLeft", getMovementAnimation("left"));
    }

    public void setBasicAnimation(String animationName, String key, int frameQuantity, int delay) {
        addAnimation(animationName, getAnimation(key, frameQuantity, delay));
    }

    private Animation getAnimation(String key, int frameQuantity, int delay) {
        Animation animation = new Animation(delay);
        for(int i = 0; i < frameQuantity; i++) {
            try {
                String path = "/" + resourceName + "/" + key + "-" + (i+1) + ".png";
                BufferedImage sprite = spriteLoader.loadImage(path);
                animation.addFrame(new Sprite(sprite));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return animation;
    }

    private Animation getMovementAnimation(String key) {
        Animation animation = new Animation(100);
        try {
            BufferedImage first = spriteLoader.loadImage("/" + resourceName + "/" + key + "-1.png");
            BufferedImage second = spriteLoader.loadImage("/" + resourceName + "/" + key + "-2.png");
            BufferedImage third = spriteLoader.loadImage("/" + resourceName + "/" + key + "-3.png");
            animation.addFrame(new Sprite(first));
            animation.addFrame(new Sprite(second));
            animation.addFrame(new Sprite(first));
            animation.addFrame(new Sprite(third));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return animation;
    }

    private void addAnimation(String key, Animation animation) {
        animations.put(key, animation);
    }

    public Map<String, Animation> build() {
        return animations;
    }
}
