package Map;

import GameEngine.GameConstants;
import Tiles.TileRenderer;
import Tiles.TileType;

import java.awt.*;

public class MapRenderer {

    public static void renderMap(GameMap gameMap, Graphics2D g2) {
        int [][] map = gameMap.getGameMap();
        for(int i=0; i<gameMap.getNumRows(); i++) {
            for(int j=0; j<gameMap.getNumCols(); j++) {
                int tileId = map[i][j];
                TileRenderer.renderTile(TileType.values()[tileId], j * GameConstants.tileSize, i * GameConstants.tileSize, g2);
            }
        }
    }
}
