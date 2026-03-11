package GameEngine;

public class GameConstants {

    public static final int ORIGINAL_TILE_SIZE = 16;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    public static final int MAX_SCREEN_COLS = 16;
    public static final int MAX_SCREEN_ROWS = 12;
    public static final int SCREEN_WIDTH = MAX_SCREEN_COLS * TILE_SIZE;
    public static final int SCREEN_HEIGHT = MAX_SCREEN_ROWS * TILE_SIZE;
    public static final int FPS = 60;


    public static final String GAME_MODE_DEV = "DEV";
    public static final String GAME_MODE_PROD = "PROD";
}
