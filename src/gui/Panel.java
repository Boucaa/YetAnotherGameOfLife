package gui;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;

/**
 * Created by colander on 6/5/17.
 * The main JPanel class, which draws the game grid and allows the user to interact with it by clicking.
 */
public class Panel extends JPanel {

    private Game game;

    private final static int PIXEL_SIZE = 10;
    private final static Color DEAD_COLOR = Color.BLACK;
    private final static Color ALIVE_COLOR = Color.GREEN;

    private final static int PERIOD = 300;

    private boolean running = true;

    boolean isRunning() {
        return running;
    }

    void setRunning(boolean running) {
        this.running = running;
    }

    Panel() {
        this.game = new Game(100, 100);

        Timer timer = new Timer();
        TimerTask stepAndRedrawTask = new TimerTask() {
            @Override
            public void run() {
                if (running) {
                    Panel.this.game.step();
                }
                Panel.this.repaint();
            }
        };
        timer.scheduleAtFixedRate(stepAndRedrawTask, PERIOD, PERIOD);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX() / PIXEL_SIZE;
                int y = e.getY() / PIXEL_SIZE;
                game.flip(x, y);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("drawing");
        boolean[][] map = game.getMap();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                g.setColor(map[i][j] ? ALIVE_COLOR : DEAD_COLOR);
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }


}
