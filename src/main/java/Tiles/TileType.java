package Tiles;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Getter

public enum TileType {
    DUMMY(loadImage("Tiles/grass_short.png"), false),
    GRASS_SHORT(loadImage("Tiles/grass_short.png"), false),
    GRASS_LONG(loadImage("Tiles/grass.png"), false),
    TREE(loadImage("Tiles/tree_01.png"), true),
    ROAD(loadImage("Tiles/road_02.png"), false),
    WALL(loadImage("Tiles/wall.png"), true);

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
