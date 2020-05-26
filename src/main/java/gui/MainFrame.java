package src.main.java.gui;

import src.main.java.GameOfLife;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 * This class is responsible of creating the JFrame on which
 * the application is built.
 *
 * @author Edoardo Riggio
 */
public class MainFrame extends JFrame {

    private final GameOfLife gameOfLife;

    private final JPanel panel;
    private final JPanel gridGui;
    private final JMenuBar menu;
    private final JButton clear;
    private final JButton random;
    private final JButton decreaseSpeed;
    private final JButton increaseSpeed;
    private final JLabel speedLabel;
    private final JButton pauseOrPlay;

    /**
     * Constructor for the MainFrame class.
     * @param gameOfLife An instance of game of life
     * @param size The size of the grid's squares
     */
    public MainFrame(final GameOfLife gameOfLife, final int size) {
        super("Game of Life");

        this.gameOfLife = gameOfLife;

        this.panel = new JPanel();
        this.gridGui = new GridPanel(gameOfLife, size);
        this.menu = new Menu(gameOfLife);

        this.clear = new JButton("Clear grid");
        this.random = new JButton("Random");
        this.decreaseSpeed = new JButton("-");
        this.increaseSpeed = new JButton("+");
        this.speedLabel = new JLabel(gameOfLife.getSpeed().toString());
        this.pauseOrPlay = new JButton("Pause");
        //terminate process when frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();
        buildFrame();
    }

    /**
     * This method creates the components for the frame.
     */
    private void addComponents() {
        panel.add(pauseOrPlay);
        panel.add(random);
        panel.add(clear);
        panel.add(decreaseSpeed);
        panel.add(speedLabel);
        panel.add(increaseSpeed);

        addDecorators();
    }

    /**
     * Add the decorators to the buttons.
     */
    private void addDecorators() {
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

        pauseOrPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                gameOfLife.pauseOrPlayGame();
                final String currentText = pauseOrPlay.getText();
                final String newText = "Pause".equals(currentText) ? "Play" : "Pause";
                pauseOrPlay.setText(newText);
            }
        });
    }

    /**
     * Method to build the frame.
     */
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
