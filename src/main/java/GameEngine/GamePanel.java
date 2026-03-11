package GameEngine;

import Entities.Entity;
import Entities.Player;
import Map.MapManager;

import javax.swing.*;
import java.awt.*;

import static GameEngine.GameConstants.TILE_SIZE;

public class GamePanel extends JPanel implements Runnable{

    public String gameMode = GameConstants.GAME_MODE_PROD;

    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    MapManager mapManager = new MapManager();
    Graphics2D g2;

    Entity player = new Player(this, keyHandler);

    public GamePanel() {
        setPreferredSize(new Dimension(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT));
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

        if(gameMode.equals(GameConstants.GAME_MODE_DEV)) drawScreenGrid(g2);
    }

    private void initializeGame() {
        mapManager.loadMap("Maps/map.txt");
        CollisionChecker.mapManager = mapManager;
        CollisionChecker.tileTypes = mapManager.getTILE_TYPES();
    }

    private void drawScreenGrid(Graphics2D g2) {
        for(int col = 0; col < mapManager.getCurrentMap().getNumCols(); col++) {
            for(int row = 0; row < mapManager.getCurrentMap().getNumRows(); row++) {

                int worldX = col * TILE_SIZE;
                int worldY = row * TILE_SIZE;

                int screenX = worldX - player.getWorldX() + player.getXPosition();
                int screenY = worldY - player.getWorldY() + player.getYPosition();

                g2.drawRect(screenX, screenY, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
