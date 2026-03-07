package GameEngine;

public class GameConstants {

    public static final int originalTileSize = 16;
    public static final int scale = 3;
    public static final int tileSize = originalTileSize * scale;
    public static final int maxScreenCols = 16;
    public static final int maxScreenRows = 12;
    public static final int screenWidth = maxScreenCols * tileSize;
    public static final int screenHeight = maxScreenRows * tileSize;
    public static final int FPS = 60;

}
