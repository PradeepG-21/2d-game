package Map;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class MapManager {
    @Getter @Setter
    GameMap currentMap;

    public void renderMap(Graphics2D g2) {
        MapRenderer.renderMap(currentMap, g2);
    }

    public void loadMap(String mapPath) {
        currentMap = MapLoader.loadGameMap(mapPath);
    }
}
