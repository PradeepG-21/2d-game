package Map;

import GameEngine.GameConstants;
import Tiles.TileRenderer;
import Tiles.TileType;

import java.awt.*;

public class MapRenderer {

    private static final TileType[] TILE_TYPES = TileType.values();

    public static void renderMap(GameMap gameMap, int playerWorldX, int playerWorldY, Graphics2D g2) {

        int[][] map = gameMap.getGameMap();

        int cameraX = playerWorldX - GameConstants.SCREEN_WIDTH / 2 + GameConstants.TILE_SIZE / 2;
        int cameraY = playerWorldY - GameConstants.SCREEN_HEIGHT / 2 + GameConstants.TILE_SIZE / 2;

        // Adding extra tiles off camera to avoid blank tiles for partially visible tiles
        int leftTileIndex = cameraX / GameConstants.TILE_SIZE - 1;
        int topTileIndex = cameraY / GameConstants.TILE_SIZE - 1;

        int rightTileIndex = leftTileIndex + GameConstants.MAX_SCREEN_COLS + 2;
        int bottomTileIndex = topTileIndex + GameConstants.MAX_SCREEN_ROWS + 2;

        leftTileIndex = Math.max(0, leftTileIndex);
        topTileIndex = Math.max(0, topTileIndex);

        rightTileIndex = Math.min(gameMap.getNumCols(), rightTileIndex);
        bottomTileIndex = Math.min(gameMap.getNumRows(), bottomTileIndex);

        for(int i = topTileIndex; i < bottomTileIndex; i++) {
            for (int j = leftTileIndex; j < rightTileIndex; j++) {

                int tileId = map[i][j];

                int worldX = j * GameConstants.TILE_SIZE;
                int worldY = i * GameConstants.TILE_SIZE;

                int screenX = worldX - cameraX;
                int screenY = worldY - cameraY;

                TileRenderer.renderTile(TILE_TYPES[tileId], screenX, screenY, g2);
            }
        }
    }
}
