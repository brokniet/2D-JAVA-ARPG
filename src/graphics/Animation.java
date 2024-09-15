package graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {

    private List<Sprite> frames;
    private int currentFrame;
    private long lastUpdate;
    private long delay;

    public Animation(long delay) {
        this.frames = new ArrayList<>();
        this.delay = delay;
        this.currentFrame = 0;
        this.lastUpdate = System.currentTimeMillis();
    }

    public void addFrame(Sprite sprite) {
        frames.add(sprite);
    }

    public BufferedImage getCurrentFrame() {
        return frames.get(currentFrame).getImage();
    }

    public void update() {
        if (System.currentTimeMillis() - lastUpdate > delay) {
            currentFrame++;
            if (currentFrame >= frames.size()) {
                currentFrame = 0;
            }
            lastUpdate = System.currentTimeMillis();
        }
    }
}
