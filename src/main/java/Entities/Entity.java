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
    GamePanel gamePanel;
    KeyHandler keyHandler;

    String direction;

    int frameCounter = 0;
    int imageVersion = 1;


    public Entity(int xPosition, int yPosition, int speed, GamePanel gamePanel, KeyHandler keyHandler) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.speed = speed;
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        this.tileSize = gamePanel.getTileSize();
    }

    public void update() {
        handleInput();
    }

    public abstract void draw(Graphics2D g2);

    public abstract void handleInput();

    public abstract BufferedImage getEntityImage(String direction);

    public abstract void readEntityImages();
}
