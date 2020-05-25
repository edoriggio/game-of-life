package src.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This class is responsible of creating the JFrame on which
 * the application is built.
 *
 * @author Edoardo Riggio
 * @version 24/05/2020
 */
public class FrameMain extends JFrame {

    private final JPanel panel;
    private final JPanel gridGui;
    private final JMenuBar menu;
    private final JButton clear;
    private final JButton random;
    private final JButton decreaseSpeed;
    private final JButton increaseSpeed;
    private final JLabel speedLabel;

    /**
     * Constructor for the FrameMain class.
     * @param gameOfLife An instance of game of life
     * @param size The size of the grid's squares
     */
    public FrameMain(final GameOfLife gameOfLife, final int size) {
        super("Game of Life");

        this.panel = new JPanel();
        this.gridGui = new GridGui(gameOfLife, size);
        this.menu = new Menu(gameOfLife);

        this.clear = new JButton("Clear grid");
        this.random = new JButton("Random");
        this.decreaseSpeed = new JButton("-");
        this.increaseSpeed = new JButton("+");
        this.speedLabel = new JLabel(gameOfLife.getSpeed().toString());

        addComponents(gameOfLife);
        buildFrame();
    }

    private void addComponents(final GameOfLife gameOfLife) {
        panel.add(random);
        panel.add(clear);
        panel.add(decreaseSpeed);
        panel.add(speedLabel);
        panel.add(increaseSpeed);

        addDecorators(gameOfLife);
    }

    private void addDecorators(final GameOfLife gameOfLife) {
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.clearGrid();
            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.randomlyPopulate();
            }
        });

        increaseSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.changeSpeed(100);
                speedLabel.setText(gameOfLife.getSpeed().toString());
            }
        });

        decreaseSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.changeSpeed(-100);
                speedLabel.setText(gameOfLife.getSpeed().toString());
            }
        });
    }

    private void buildFrame() {
        add(gridGui);
        add(panel, BorderLayout.SOUTH);
        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(gridGui.getWidth(),
                gridGui.getHeight() + panel.getHeight() + menu.getHeight() + 31));
    }

}
