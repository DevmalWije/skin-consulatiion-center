package phase1ToPhase3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomButton extends JButton {
    public CustomButton(String text) {
        super(text);

        // Set the border to a rounded rectangle with a thickness of 2
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));

        // Set the content area to be transparent
//        setContentAreaFilled(false);

        // Set the foreground and background colors
        setForeground(Color.WHITE);


        // Add a mouse listener to change the background color on hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(159, 227, 237));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(30, 153, 204));
            }
        });
    }
}
