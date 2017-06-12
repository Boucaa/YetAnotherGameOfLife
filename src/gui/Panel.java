package gui;

import logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;

/**
 * Created by colander on 6/5/17.
 */
public class Panel extends JPanel {

    private Game game;

    private final static int PIXEL_SIZE = 10;
    private final static Color DEAD_COLOR = Color.BLACK;
    private final static Color ALIVE_COLOR = Color.GREEN;

    public final static int PERIOD = 300;

    boolean running = true;

    Timer timer;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (running) {
                Panel.this.game.step();
            }
            Panel.this.repaint();
        }
    };

    public Panel() {
        this.game = new Game(100, 100);

        this.timer = new Timer();

        timer.scheduleAtFixedRate(task, PERIOD, PERIOD);

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
