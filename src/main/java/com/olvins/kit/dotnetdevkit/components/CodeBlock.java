package com.olvins.kit.dotnetdevkit.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CodeBlock {
    private int offsetX, offsetY;
    private JPanel panel;
    private JButton button1;

    public JPanel getPanel() {
        return panel;
    }

    public CodeBlock() {
        // Set bounds and layout
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1000, 1000));
        button1.setBounds(50, 50, 120, 120);

        // Add mouse listeners to button
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                offsetX = e.getX();
                offsetY = e.getY();
            }
        });

        button1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                button1.setLocation(button1.getX() + e.getX() - offsetX, button1.getY() + e.getY() - offsetY);
            }
        });

        // Add button to panel
        panel.add(button1);
    }
}
