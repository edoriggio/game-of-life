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
        Menu menu = new Menu(gameOfLife);

        JButton randomButton = new JButton("Clear grid");
        panel.add(randomButton);
        
        this.setLocationRelativeTo(null);
        this.add(panel, BorderLayout.SOUTH);
        this.setJMenuBar(menu);
        this.add(gridGui);
        pack();

        this.setMinimumSize(new Dimension(gridGui.getWidth(), (gridGui.getHeight() + panel.getHeight() + menu.getHeight() + 31)));

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.clearGrid();
            }
        });


    }

    public static void showError(String error) {
        Frame errorFrame = new JFrame();
        errorFrame.setLocationRelativeTo(null);
        errorFrame.add(new Label(error));
        errorFrame.pack();
        errorFrame.setVisible(true);
    }
}
