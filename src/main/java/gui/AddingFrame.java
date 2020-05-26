package src.main.java.gui;

import src.main.java.GameOfLife;
import src.main.java.Pattern;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is responsible for creating the frame to add patterns.
 * By inserting an x and y value, the pattern will be added in those
 * coordinates.
 *
 * @author Edoardo Riggio
 */
public class AddingFrame extends JFrame {

    private final int rows;
    private final int cols;
    private final Pattern pattern;
    private final GameOfLife gameOfLife;
    private final JTextField input1;
    private final JTextField input2;
    private final JButton add;
    private final JButton cancel;

    /**
     * Constructor for the AddingFrame class.
     * @param pattern The pattern to be added
     * @param gameOfLife An instance of game of life
     */
    public AddingFrame(final Pattern pattern, final GameOfLife gameOfLife) {
        super("Add a " + pattern.getName());

        this.rows = gameOfLife.getCurrentGrid().getRows();
        this.cols = gameOfLife.getCurrentGrid().getColumns();
        this.pattern = pattern;
        this.gameOfLife = gameOfLife;

        this.input1 = new JTextField();
        this.input2 = new JTextField();
        this.add = new JButton("Add");
        this.cancel = new JButton("Cancel");

        final JPanel panel = new JPanel();
        final GridBagLayout layout = new GridBagLayout();
        final GridBagConstraints constraints = new GridBagConstraints();

        panel.setLayout(layout);

        buildFrame(constraints, panel);
        displayFrame();
    }

    /**
     * This method creates the first field of the frame.
     * @param constraints The constraint used
     * @param panel The panel on which the components have to be placed
     */
    private void addFirstField(final GridBagConstraints constraints, final JPanel panel) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new Label("Coordinate x:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        input1.setPreferredSize(new Dimension(50, 20));
        panel.add(input1, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(new Label("(Max. " + cols + ")"), constraints);
    }

    /**
     * This method creates the second field of the frame.
     * @param constraints The constraint used
     * @param panel The panel on which the components have to be placed
     */
    private void addSecondField(final GridBagConstraints constraints, final JPanel panel) {
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new Label("Coordinate y:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        input2.setPreferredSize(new Dimension(50, 20));
        panel.add(input2, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(new Label("(Max. " + rows + ")"), constraints);
    }

    /**
     * This method creates the buttons of the frame.
     * @param constraints The constraint used
     * @param panel The panel on which the components have to be placed
     */
    private void addButtons(final GridBagConstraints constraints, final JPanel panel) {
        // Cancel Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(cancel, constraints);

        // Add Button
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        panel.add(add, constraints);

        addDecorators();
    }

    /**
     * This method creates the decorators of the buttons.
     */
    private void addDecorators() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (input1.getText().isBlank() && input2.getText().isBlank()) {
                    gameOfLife.addPattern(pattern, 0, 0);
                } else {
                    gameOfLife.addPattern(pattern, Integer.parseInt(input2.getText()),
                            Integer.parseInt(input1.getText()));
                }

                dispose();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                dispose();
            }
        });
    }

    /**
     * This method builds the frame together.
     * @param constraints The constraint used
     * @param panel The panel on which the components have to be placed
     */
    private void buildFrame(final GridBagConstraints constraints, final JPanel panel) {
        addFirstField(constraints, panel);
        addSecondField(constraints, panel);
        addButtons(constraints, panel);

        add(panel);
    }

    /**
     * This method displays the frame.
     */
    private void displayFrame() {
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setVisible(true);
    }

}
