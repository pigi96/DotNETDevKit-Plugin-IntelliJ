package com.olvins.kit.dotnetdevkit.scratch;

import com.olvins.kit.dotnetdevkit.scratch.blocks.DrawableBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private ArrayList<DrawableBlock> blocks;
    private DrawableBlock selectedBlock;

    public Canvas() {
        blocks = new ArrayList<>();
        blocks.add(new DrawableBlock(0, 0, 200, 200, Color.WHITE, "Testing one two three"));

        handleDrawableBlocks();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom painting code
        for (DrawableBlock block : blocks) {
            block.draw(g);
        }
    }

    private void handleDrawableBlocks() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (DrawableBlock block : blocks) {
                    if (block.contains(e.getPoint())) {
                        selectedBlock = block;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedBlock = null;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedBlock != null) {
                    selectedBlock.setPosition(e.getX(), e.getY());
                    repaint();
                }
            }
        });
    }
}

