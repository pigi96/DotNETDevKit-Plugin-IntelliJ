package com.olvins.kit.dotnetdevkit.scratch.blocks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawableBlock {
    private Rectangle bounds;
    private Color color;
    private String text;
    private BufferedImage image;

    public DrawableBlock(int x, int y, int width, int height, Color color, String text) {
        this.bounds = new Rectangle(x, y, width, height);
        this.color = color;
        this.text = text;

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
            image = null;
        }
    }

    public boolean contains(Point p) {
        return bounds.contains(p);
    }

    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);

        if (image != null) {
            g.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, null);
        }

        g.setColor(Color.BLACK);

        drawCenteredText(g, text, bounds);
    }

    private void drawCenteredText(Graphics g, String text, Rectangle rect) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(text, x, y);
    }
}
