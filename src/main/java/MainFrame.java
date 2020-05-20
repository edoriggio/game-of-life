package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame(final GameOfLife gameOfLife, int size) {
        super("Game of Life");

        JPanel panel = new JPanel();
        GridGui gridGui = new GridGui(gameOfLife, size);
        Menu menu = new Menu();

        JButton randomButton = new JButton("add Glider");
        panel.add(randomButton);

        this.add(panel, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        this.add(gridGui);
        pack();

        this.setMinimumSize(new Dimension(gridGui.getWidth(), (gridGui.getHeight() + panel.getHeight())));

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.addGlider(0,0);
            }
        });
    }
}
