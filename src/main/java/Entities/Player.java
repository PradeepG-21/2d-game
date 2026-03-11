package Entities;

import GameEngine.CollisionChecker;
import GameEngine.GameConstants;
import GameEngine.GamePanel;
import GameEngine.KeyHandler;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

@Getter
@Setter

public class Player extends Entity {

    private String imagePath;
    private BufferedImage up1, up2, left1, left2, right1, right2, down1, down2;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(
                EntityConstants.DEFAULT_PLAYER_X,
                EntityConstants.DEFAULT_PLAYER_Y,
                EntityConstants.DEFAULT_PLAYER_SPEED,
                new Rectangle(8, 16, 32, 32),
                gamePanel,
                keyHandler
        );
        imagePath = EntityConstants.DEFAULT_PLAYER_RESOURCES_PATH;
        readEntityImages();
        setDirection("DOWN");
        setXPosition(GameConstants.SCREEN_WIDTH / 2 - (GameConstants.TILE_SIZE /2));
        setYPosition(GameConstants.SCREEN_HEIGHT /2 - (GameConstants.TILE_SIZE /2));
    }

    @Override
    public void readEntityImages() {
        try {
            setUp1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_up_1.png"))));
            setUp2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_up_2.png"))));
            setLeft1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_left_1.png"))));
            setLeft2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_left_2.png"))));
            setRight1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_right_1.png"))));
            setRight2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_right_2.png"))));
            setDown1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_down_1.png"))));
            setDown2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(imagePath + "boy_down_2.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void changeImage() {
        imageVersion = imageVersion == 1 ? 2 : 1;
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage entityImage = getEntityImage(direction);
        g2.drawImage(entityImage, getXPosition(), getYPosition(), getTileSize(), getTileSize(), null);
        if(gamePanel.gameMode.equals(GameConstants.GAME_MODE_DEV)) renderCollisionArea(g2);
    }

    @Override
    public void handleInput() {

        collision = false;

        updateEntityFrame();
        updateDirection();
        updatePosition();

    }

    private void updateDirection() {
        if(keyHandler.isUpPressed()) {
            direction = EntityConstants.DIRECTION_UP;
        }
        else if(keyHandler.isDownPressed()) {
            direction = EntityConstants.DIRECTION_DOWN;
        }
        else if(keyHandler.isRightPressed()) {
            direction = EntityConstants.DIRECTION_RIGHT;
        }
        else if(keyHandler.isLeftPressed()) {
            direction = EntityConstants.DIRECTION_LEFT;
        }
    }

    private void updatePosition() {
        if(CollisionChecker.collisionChecker(this )) return;

        if(keyHandler.isUpPressed()) {
            setWorldY(getWorldY() - getSpeed());
        }
        else if(keyHandler.isDownPressed()) {
            setWorldY(getWorldY() + getSpeed());
        }
        else if(keyHandler.isRightPressed()) {
            setWorldX(getWorldX() + getSpeed());
        }
        else if(keyHandler.isLeftPressed()) {
            setWorldX(getWorldX() - getSpeed());
        }
    }

    private void updateEntityFrame() {
        if(keyHandler.isPressed()) frameCounter++;
        if(frameCounter == 10) {
            changeImage();
            frameCounter = 0;
        }

    }

    @Override
    public BufferedImage getEntityImage(String direction) {
        return switch (direction) {
            case "UP" -> imageVersion == 1 ? up1 : up2;
            case "DOWN" -> imageVersion == 1 ? down1 : down2;
            case "LEFT" -> imageVersion == 1 ? left1 : left2;
            case "RIGHT" -> imageVersion == 1 ? right1 : right2;
            default -> down1;
        };
    }


}
