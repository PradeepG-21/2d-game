package GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;

    public boolean isUpPressed() {
        return isUpPressed;
    }

    public void setUpPressed(boolean upPressed) {
        isUpPressed = upPressed;
    }

    public boolean isDownPressed() {
        return isDownPressed;
    }

    public void setDownPressed(boolean downPressed) {
        isDownPressed = downPressed;
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        isLeftPressed = leftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }

    public void setRightPressed(boolean rightPressed) {
        isRightPressed = rightPressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // This implementation insures more than one key can be pressed at the same time
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            setUpPressed(true);
        }
        if(code == KeyEvent.VK_DOWN) {
            setDownPressed(true);
        }
        if(code == KeyEvent.VK_LEFT) {
            setLeftPressed(true);
        }
        if(code == KeyEvent.VK_RIGHT) {
            setRightPressed(true);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            setUpPressed(false);
        }
        if(code == KeyEvent.VK_DOWN) {
            setDownPressed(false);
        }
        if(code == KeyEvent.VK_LEFT) {
            setLeftPressed(false);
        }
        if(code == KeyEvent.VK_RIGHT) {
            setRightPressed(false);
        }
    }
}
