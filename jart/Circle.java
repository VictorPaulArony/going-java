import java.awt.*;
import java.util.Random;

public class Circle implements Drawable {

    private int x, y, r;
    private Color color;

    public Circle( int x, int y, int r, Color color) {
        this.x=x;
        this.y=y;
        this.r=r;
        this.color=color;

    }

    public static Circle random(int width, int height){
        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        int r = rand.nextInt(height)+ 100;
        Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        return new Circle(x, y, r, color);
    }

     @Override
    public void draw(Displayable displayable) {
        if(!(displayable instanceof Image)) return;
        Graphics2D g2d = ((Image) displayable).getGraphics();
        g2d.setColor(color);
        g2d.drawOval(x-r, y-r, 2*r, 2*r);

    }

     @Override
    public Color getColor() {
        return color;
    }

}
