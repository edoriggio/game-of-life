package src.main.java;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is responsible of creating the JFrame on which
 * the application is built.
 */
public class FrameMain extends JFrame {

    /**
     * Constructor for the FrameMain class.
     * @param gameOfLife An instance of game of life
     * @param size The size of the grid's squares
     */
    public FrameMain(final GameOfLife gameOfLife, final int size) {
        super("Game of Life");

        final JPanel panel = new JPanel();
        final GridGui gridGui = new GridGui(gameOfLife, size);
        final Menu menu = new Menu(gameOfLife);

        final JButton clear = new JButton("Clear grid");
        final JButton random = new JButton("Random");
        final JButton decreaseSpeed = new JButton("-");
        final JButton increaseSpeed = new JButton("+");
        final JLabel speedLabel = new JLabel(gameOfLife.getSpeed().toString());

        panel.add(random);
        panel.add(clear);
        panel.add(decreaseSpeed);
        panel.add(speedLabel);
        panel.add(increaseSpeed);

        add(gridGui);
        add(panel, BorderLayout.SOUTH);
        setJMenuBar(menu);
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(gridGui.getWidth(),
                gridGui.getHeight() + panel.getHeight() + menu.getHeight() + 31));

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.clearGrid();
            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.randomlyPopulate();
            }
        });

        increaseSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.changeSpeed(100);
                speedLabel.setText(gameOfLife.getSpeed().toString());
            }
        });

        decreaseSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOfLife.changeSpeed(-100);
                speedLabel.setText(gameOfLife.getSpeed().toString());
            }
        });
    }

}
