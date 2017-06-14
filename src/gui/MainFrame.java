package gui;


import javax.swing.*;
import java.awt.event.*;

/**
 * Created by colander on 6/5/17.
 * The main JFrame class, only listens for spacebar press and passes the information forward to the
 * panel, which handles the gui-logic interface.
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        Panel panel = new Panel();
        this.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    System.out.println("space pressed");
                    if (panel.isRunning()) {
                        System.out.println("zastaveno");
                        panel.setRunning(false);
                    } else {
                        System.out.println("obnoveno");
                        panel.setRunning(true);
                    }
                }
            }
        });
        this.add(panel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
