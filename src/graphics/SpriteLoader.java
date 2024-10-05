package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SpriteLoader {

    private static SpriteLoader instance;

    private SpriteLoader() { }

    public static SpriteLoader getInstance() {
        if(instance == null) instance = new SpriteLoader();
        return instance;
    }

    public BufferedImage loadImage(String path) throws IOException {
        return ImageIO.read(Objects.requireNonNull(SpriteLoader.class.getResource(path)));
    }

}
