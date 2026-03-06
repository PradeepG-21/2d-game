package Entities;

import GameEngine.GamePanel;
import GameEngine.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    public Player(int xPosition, int yPosition, int speed, GamePanel gamePanel, KeyHandler keyHandler) {
        super(
                xPosition, yPosition, speed,
                "Player/Walking Sprites/",
                gamePanel, keyHandler
        );
        setDirection("DOWN");
    }

    @Override
    public void getImages() {
        try {
            setUp1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_up_1.png"))));
            setUp2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_up_2.png"))));
            setLeft1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_left_1.png"))));
            setLeft2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_left_2.png"))));
            setRight1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_right_1.png"))));
            setRight2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_right_2.png"))));
            setDown1(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_down_1.png"))));
            setDown2(ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(getImagePath() + "boy_down_2.png"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
