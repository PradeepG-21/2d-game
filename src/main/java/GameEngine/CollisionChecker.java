package GameEngine;

import Entities.Entity;
import Entities.EntityConstants;
import Map.MapManager;
import Tiles.TileType;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public class CollisionChecker {
    static MapManager mapManager;
    static TileType[] tileTypes;

    static int collisionLeftCol;
    static int collisionRightCol;
    static int collisionTopRow;
    static int collisionBottomRow;

    public static boolean collisionChecker(Entity entity) {
        // Finding coordinates of collision area on the world map

        Rectangle entityCollisionArea = entity.getCollisionArea();

        int worldCollisionTopY = entity.getWorldY() + entityCollisionArea.y;
        int worldCollisionBottomY = entity.getWorldY() + (entityCollisionArea.y + entityCollisionArea.height);
        int worldCollisionLeftX = entity.getWorldX() + entityCollisionArea.x;
        int worldCollisionRightX = entity.getWorldX() + (entityCollisionArea.x + entityCollisionArea.width);

        collisionLeftCol = worldCollisionLeftX / GameConstants.TILE_SIZE;
        collisionRightCol = worldCollisionRightX / GameConstants.TILE_SIZE;
        collisionTopRow = worldCollisionTopY / GameConstants.TILE_SIZE;
        collisionBottomRow = worldCollisionBottomY / GameConstants.TILE_SIZE;

        // In any direction that the entity moves, there can be only 2 tiles that it collides with.
        int tileNum1 = 0, tileNum2 = 0;

        switch (entity.getDirection()) {
            case EntityConstants.DIRECTION_UP -> {
                if(worldCollisionTopY <= 0) return true;

                collisionTopRow = (worldCollisionTopY - entity.getSpeed()) / GameConstants.TILE_SIZE;
                tileNum1 = mapManager.getCurrentMap().getGameMap()[collisionTopRow][collisionLeftCol];
                tileNum2 = mapManager.getCurrentMap().getGameMap()[collisionTopRow][collisionRightCol];
            }

            case EntityConstants.DIRECTION_DOWN -> {
                if(worldCollisionBottomY >= mapManager.getCurrentMap().getNumRows() * GameConstants.TILE_SIZE) return true;

                collisionBottomRow = (worldCollisionBottomY + entity.getSpeed()) / GameConstants.TILE_SIZE;
                tileNum1 = mapManager.getCurrentMap().getGameMap()[collisionBottomRow][collisionLeftCol];
                tileNum2 = mapManager.getCurrentMap().getGameMap()[collisionBottomRow][collisionRightCol];
            }

            case EntityConstants.DIRECTION_RIGHT -> {
                if(worldCollisionRightX >= mapManager.getCurrentMap().getNumCols() * GameConstants.TILE_SIZE) return true;

                collisionRightCol = (worldCollisionRightX + entity.getSpeed()) / GameConstants.TILE_SIZE;
                tileNum1 = mapManager.getCurrentMap().getGameMap()[collisionTopRow][collisionRightCol];
                tileNum2 = mapManager.getCurrentMap().getGameMap()[collisionBottomRow][collisionRightCol];
            }

            case EntityConstants.DIRECTION_LEFT -> {
                if(worldCollisionLeftX <= 0) return true;

                collisionLeftCol = (worldCollisionLeftX - entity.getSpeed()) / GameConstants.TILE_SIZE;
                tileNum1 = mapManager.getCurrentMap().getGameMap()[collisionTopRow][collisionLeftCol];
                tileNum2 = mapManager.getCurrentMap().getGameMap()[collisionBottomRow][collisionLeftCol];
            }
        }

        return isCollisionTile(tileNum1) || isCollisionTile(tileNum2);
    }

    private static boolean isCollisionTile(int tileType) {
        return tileTypes[tileType].isCollision();
    }
}
