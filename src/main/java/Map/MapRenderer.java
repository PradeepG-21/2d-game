package Map;

import GameEngine.GameConstants;
import Tiles.TileRenderer;
import Tiles.TileType;

import java.awt.*;

public class MapRenderer {

    public static void renderMap(GameMap gameMap, int playerWorldX, int playerWorldY, Graphics2D g2) {
        int [][] map = gameMap.getGameMap();

        int leftLimit = playerWorldX / GameConstants.tileSize - GameConstants.maxScreenCols / 2;
        int topLimit = playerWorldY / GameConstants.tileSize - GameConstants.maxScreenRows / 2;

        leftLimit = Math.max(0, leftLimit);
        topLimit = Math.max(0, topLimit);

        int yRightLimit = Math.min(gameMap.getNumCols(), leftLimit + GameConstants.maxScreenCols);
        int xBottomLimit = Math.min(gameMap.getNumRows(), topLimit + GameConstants.maxScreenRows);
        for(int i=topLimit; i<xBottomLimit; i++) {
            for(int j=leftLimit; j<yRightLimit; j++) {
                int tileId = map[i][j];
                TileRenderer.renderTile(TileType.values()[tileId], (j - leftLimit) * GameConstants.tileSize, (i - topLimit) * GameConstants.tileSize, g2);
            }
        }
    }
}
