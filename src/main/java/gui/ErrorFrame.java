package src.main.java.gui;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class is responsible for creating the frame to display errors.
 * This frame will appear when a PatternException is caught.
 *
 * @author Edoardo Riggio
 */
public class ErrorFrame extends JFrame {

    /**
     * Constructor for the ErrorFrame class.
     * @param error The error message to display
     */
    public ErrorFrame(final String error) {
        super("Error");

        final JPanel panel = new JPanel();
        final JButton ok = new JButton("OK");

        panel.add(ok);

        add(new Label(error));
        add(panel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                dispose();
            }
        });
    }

}
