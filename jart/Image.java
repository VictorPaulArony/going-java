import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Image implements Displayable {

    private BufferedImage image;
    private Graphics2D g2d;
    private int width, height;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    @Override
    public void display(int width, int height, Color color) {
        g2d.setColor(color);
        g2d.fillRect(width, height, 1, 1);
    }

    @Override
    public void save(String fileName) {
        g2d.dispose();
        try {
            ImageIO.write(image, "png", new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getters & setters
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Graphics2D getGraphics() {
        return g2d;
    }
}
