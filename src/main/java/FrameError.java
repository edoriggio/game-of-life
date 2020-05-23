package src.main.java;

import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FrameError extends JFrame {

    public FrameError(final String error) {
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
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });
    }

}
