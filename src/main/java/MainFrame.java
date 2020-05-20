package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private GameOfLife gameOfLife;

    public MainFrame(final GameOfLife gameOfLife, int size) {
        super("Game of Life");
        this.gameOfLife = gameOfLife;

        JPanel panel = new JPanel();
        GridGui gridGui = new GridGui(gameOfLife, size);

        JButton randomButton = new JButton("add Glider");
        panel.add(randomButton);
        this.add(panel, BorderLayout.SOUTH);
        this.add(gridGui);
        pack();

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.addGlider(0,0);
            }
        });
    }
}
