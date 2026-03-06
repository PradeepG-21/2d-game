package Entities;

import GameEngine.GamePanel;
import GameEngine.KeyHandler;

public class RectangleKun extends Entity {


    public RectangleKun(int xPosition, int yPosition, int speed, String imagePath, GamePanel gamePanel, KeyHandler keyHandler) {
        super(xPosition, yPosition, speed, imagePath, gamePanel, keyHandler);
    }

    @Override
    public void getImages() {
    }
}
