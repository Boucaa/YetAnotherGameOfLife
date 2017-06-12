package gui;


import javax.swing.*;
import java.awt.event.*;

import static gui.Panel.PERIOD;

/**
 * Created by colander on 6/5/17.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        Panel panel = new Panel();
        this.add(panel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("space pressed");
                    if (panel.running) {
                        System.out.println("zastaveno");
                        panel.running = false;
                    } else {
                        System.out.println("obnoveno");
                        panel.running = true;
                    }
                }
            }
        });
    }
}
