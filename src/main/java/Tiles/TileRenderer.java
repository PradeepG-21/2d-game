package Tiles;

import GameEngine.GameConstants;

import java.awt.*;

public class TileRenderer {

    public static void renderTile(TileType tile, int xPosition, int yPosition, Graphics2D g2) {
        g2.drawImage(tile.getTileImage(), xPosition, yPosition, GameConstants.tileSize, GameConstants.tileSize, null);
    }
}
