package src.main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAdding extends JFrame {

    public FrameAdding(final Pattern pattern, final int rows, final int cols,
                       final GameOfLife gameOfLife) {
        super("Add a " + pattern.getName());

        final JPanel panel = new JPanel();
        final GridBagLayout layout = new GridBagLayout();
        final GridBagConstraints constraints = new GridBagConstraints();

        panel.setLayout(layout);

//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        constraints.gridwidth = 3;
//        panel.add(new Label("Please insert the x and y coordinates of the pattern "), constraints);

        // X Coordinate row
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new Label("Coordinate x:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        final JTextField input1 = new JTextField();
        input1.setPreferredSize(new Dimension(50, 20));
        panel.add(input1, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(new Label("(Max. " + cols + ")"), constraints);

        // Y Coordinate row
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new Label("Coordinate y:"), constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        final JTextField input2 = new JTextField();
        input2.setPreferredSize(new Dimension(50, 20));
        panel.add(input2, constraints);

        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(new Label("(Max. " + rows + ")"), constraints);

        // Cancel Button
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        final JButton cancel = new JButton("Cancel");
        panel.add(cancel, constraints);

        // Add Button
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        final JButton add = new JButton("Add");
        panel.add(add, constraints);

        add(panel);

        pack();
        setLocationRelativeTo(null);
        setMinimumSize(this.getSize());
        setVisible(true);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gameOfLife.addPattern(pattern, Integer.parseInt(input2.getText()),
                        Integer.parseInt(input1.getText()));
                dispose();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

}
