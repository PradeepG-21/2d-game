package Entities;

import GameEngine.GameConstants;

public class EntityConstants {

    // Player Constants
    public static final int DEFAULT_PLAYER_X = 25 * GameConstants.TILE_SIZE - GameConstants.TILE_SIZE / 2;
    public static final int DEFAULT_PLAYER_Y = 25 * GameConstants.TILE_SIZE - GameConstants.TILE_SIZE / 2;
    public static final int DEFAULT_PLAYER_SPEED = 3;
    public static final String DEFAULT_PLAYER_RESOURCES_PATH = "Player/Walking Sprites/";

    // Direction Constants
    public static final String DIRECTION_UP = "UP";
    public static final String DIRECTION_DOWN = "DOWN";
    public static final String DIRECTION_LEFT = "LEFT";
    public static final String DIRECTION_RIGHT = "RIGHT";
}
