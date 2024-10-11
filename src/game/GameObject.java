package game;

import java.awt.*;

public interface GameObject {

    public default void draw(Graphics2D graphics) {}

    public default void update() {}

}
