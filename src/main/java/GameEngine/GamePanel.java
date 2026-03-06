package GameEngine;

import Entities.Entity;
import Entities.Player;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    @Getter
    final int tileSize = originalTileSize * scale;
    final int maxScreenCols = 16;
    final int maxScreenRows = 12;
    final int screenWidth = maxScreenCols * tileSize;
    final int screenHeight = maxScreenRows * tileSize;
    final int FPS = 60;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();

    // Default Player Position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    Entity player = new Player(playerX, playerY, playerSpeed, this, keyHandler);

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Creating the game loop
        double drawInterval = (double) 1000000000 / FPS;
        long previousTime = System.nanoTime();
        long currentTime;
        double delta = 0;

        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += ((currentTime - previousTime) / drawInterval);

            // Update information such as character positions
            if(delta >= 1) {
                update();
                repaint();
                delta --;
            }

            previousTime = currentTime;
        }

    }

    void update() {
        player.update();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }

}
