package Entities;

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

public class Player extends Entity{

    private String imagePath;
    private BufferedImage up1, up2, left1, left2, right1, right2, down1, down2;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        super(EntityConstants.DEFAULT_PLAYER_X, EntityConstants.DEFAULT_PLAYER_Y, EntityConstants.DEFAULT_PLAYER_SPEED, gamePanel, keyHandler);
        imagePath = EntityConstants.DEFAULT_PLAYER_RESOURCES_PATH;
        readEntityImages();
        setDirection("DOWN");
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
    }

    @Override
    public void handleInput() {
        // Our 2D game cannot allow characters to move diagonally
        // If this is to be changed, convert all ifs to else ifs
        if(keyHandler.isPressed()) frameCounter++;

        if(keyHandler.isUpPressed()) {
            setYPosition(getYPosition() - getSpeed());
            direction = "UP";
        }
        else if(keyHandler.isDownPressed()) {
            setYPosition(getYPosition() + getSpeed());
            direction = "DOWN";
        }
        else if(keyHandler.isRightPressed()) {
            setXPosition(getXPosition() + getSpeed());
            direction = "RIGHT";
        }
        else if(keyHandler.isLeftPressed()) {
            setXPosition(getXPosition() - getSpeed());
            direction = "LEFT";
        }

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
