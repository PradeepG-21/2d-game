package Map;
import Tiles.TileType;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class MapManager {
    @Getter @Setter
    GameMap currentMap;
    @Getter
    TileType[] TILE_TYPES = TileType.values();

    public void renderMap(Graphics2D g2, int playerWorldX, int playerWorldY) {
        MapRenderer.renderMap(currentMap, playerWorldX, playerWorldY, g2);
    }

    public void loadMap(String mapPath) {
        currentMap = MapLoader.loadGameMap(mapPath);
    }
}
