import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Rectangle implements Drawable {
    private Color color;
    private Point p1, p2;

    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public void draw(Displayable displayable) {
        if (!(displayable instanceof Image)) return;
        Graphics2D g2d = ((Image) displayable).getGraphics();
        Random rand = new Random();

        for (int i = 0; i <= 5; i++) {
            p1 = new Point(rand.nextInt(((Image) displayable).getWidth()), rand.nextInt(((Image) displayable).getHeight()));
            p2 = new Point(rand.nextInt(((Image) displayable).getWidth()), rand.nextInt(((Image) displayable).getHeight()));
            color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

            g2d.setColor(color);

            int x = Math.min(p1.x, p2.y);
            int y = Math.min(p1.x, p2.y);
            int width = Math.abs(p2.x - p1.x);
            int height = Math.abs(p2.y - p1.y);

            g2d.drawRect(x, y, width, height);

        }
    }

    @Override
    public Color getColor() {
        return color;
    }
}
