package Entities;

import GameEngine.GamePanel;
import GameEngine.KeyHandler;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@Setter

public abstract class Entity {
    private int tileSize;

    private int xPosition;
    private int yPosition;
    private int speed;
    private GamePanel gamePanel;
    private KeyHandler keyHandler;

    private String imagePath;
    private BufferedImage up1, up2, left1, left2, right1, right2, down1, down2;
    String direction;


    public Entity(int xPosition, int yPosition, int speed, String imagePath, GamePanel gamePanel, KeyHandler keyHandler) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = speed;
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.tileSize = gamePanel.getTileSize();
        this.imagePath = imagePath;
        getImages();
    }

    public void update() {
        handleInput();
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.WHITE);
//        g2.fillRect(xPosition, yPosition, tileSize, tileSize);

        BufferedImage entityImage = getEntityImage(direction);
        g2.drawImage(entityImage, xPosition, yPosition, tileSize, tileSize, null);

    }

    public void handleInput() {
        // Our 2D game cannot allow characters to move diagonally
        // If this is to be changed, convert all ifs to else ifs
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
    }

    BufferedImage getEntityImage(String direction) {
        switch(direction) {
            case "UP":
                return up1;
            case "DOWN":
                return down1;
            case "LEFT":
                return left1;
            case "RIGHT":
                return right1;
        }
        return down1;
    }

    public abstract void getImages();
}
