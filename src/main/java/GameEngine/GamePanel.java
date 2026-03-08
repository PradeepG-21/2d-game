package GameEngine;

import Entities.Entity;
import Entities.Player;
import Map.MapManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    MapManager mapManager = new MapManager();
    Graphics2D g2;

    Entity player = new Player(this, keyHandler);

    public GamePanel() {
        setPreferredSize(new Dimension(GameConstants.screenWidth, GameConstants.screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
        initializeGame();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        // Creating the game loop
        double drawInterval = (double) 1000000000 / GameConstants.FPS;
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
        g2 = (Graphics2D) g;

        mapManager.renderMap(g2, player.getWorldX(), player.getWorldY());
        player.draw(g2);
    }

    private void initializeGame() {
        mapManager.loadMap("Maps/map.txt");
    }
}
