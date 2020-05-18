package src.main.java;

import javax.swing.*;

public class MainFrame extends JFrame {

    private GameOfLife gameOfLife;

    public MainFrame(GameOfLife gameOfLife, int size) {
        super("Game of Life");
        this.gameOfLife = gameOfLife;
        GridGui gridGui = new GridGui(gameOfLife, size);
        this.add(gridGui);
        pack();
    }
}
