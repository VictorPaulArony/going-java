import java.awt.Color;
import java.awt.Graphics2D;

public class Triangle implements Drawable {
    private Color color;
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public void draw(Displayable displayable) {
        if (!(displayable instanceof Image))
            return;
        Graphics2D g2d = ((Image) displayable).getGraphics();
        g2d.setColor(color.WHITE);
        int[] xs = { p1.x, p2.x, p3.x };
        int[] ys = { p1.y, p2.y, p3.y };

        g2d.drawPolygon(xs, ys, 3);

    }

    @Override
    public Color getColor() {
        return color;
    }
}
