package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SpriteLoader {

    public static BufferedImage loadImage(String path) throws IOException {
        //return ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/test3.png")));
        return ImageIO.read(Objects.requireNonNull(SpriteLoader.class.getResource(path)));
    }

}
