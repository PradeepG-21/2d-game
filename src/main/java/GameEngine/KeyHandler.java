package GameEngine;

import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
@Setter

public class KeyHandler implements KeyListener {

    private boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;

    @Override
    public void keyTyped(KeyEvent e) {}

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
