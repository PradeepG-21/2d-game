package Map;

import GameEngine.GameConstants;
import Tiles.TileRenderer;
import Tiles.TileType;

import java.awt.*;

public class MapRenderer {

    private static final TileType[] TILE_TYPES = TileType.values();

    public static void renderMap(GameMap gameMap, int playerWorldX, int playerWorldY, Graphics2D g2) {

        int[][] map = gameMap.getGameMap();

        int cameraX = playerWorldX - GameConstants.screenWidth / 2;
        int cameraY = playerWorldY - GameConstants.screenHeight / 2;

        // Adding extra tiles off camera to avoid blank tiles for partially visible tiles
        int leftTileIndex = cameraX / GameConstants.tileSize - 1;
        int topTileIndex = cameraY / GameConstants.tileSize - 1;

        int rightTileIndex = leftTileIndex + GameConstants.maxScreenCols + 2;
        int bottomTileIndex = topTileIndex + GameConstants.maxScreenRows + 2;

        leftTileIndex = Math.max(0, leftTileIndex);
        topTileIndex = Math.max(0, topTileIndex);

        rightTileIndex = Math.min(gameMap.getNumCols(), rightTileIndex);
        bottomTileIndex = Math.min(gameMap.getNumRows(), bottomTileIndex);

        for(int i = topTileIndex; i < bottomTileIndex; i++) {
            for (int j = leftTileIndex; j < rightTileIndex; j++) {

                int tileId = map[i][j];

                int worldX = j * GameConstants.tileSize;
                int worldY = i * GameConstants.tileSize;

                int screenX = worldX - cameraX;
                int screenY = worldY - cameraY;

                TileRenderer.renderTile(TILE_TYPES[tileId], screenX, screenY, g2);
            }
        }
    }
}
