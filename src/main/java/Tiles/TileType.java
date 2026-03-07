package Tiles;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Getter

public enum TileType {
    GRASS_SHORT(loadImage("Tiles/grass_short.png"), false),
    WALL(loadImage("Tiles/wall.png"), true),
    GRASS_LONG(loadImage("Tiles/grass.png"), false);

    private final BufferedImage tileImage;
    private final boolean collision;

    TileType(BufferedImage tileImage, boolean collision) {
        this.tileImage = tileImage;
        this.collision = collision;
    }

    private static BufferedImage loadImage(String spritePath) {
        try {
            return ImageIO.read(Objects.requireNonNull(TileType.class.getClassLoader().getResourceAsStream(spritePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
