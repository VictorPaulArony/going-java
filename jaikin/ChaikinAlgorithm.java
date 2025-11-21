import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

public class ChaikinAlgorithm extends JPanel {
    private static final int POINT_RADIUS = 6;
    private static final int MAX_STEPS = 7;
    private static final int ANIMATION_DELAY = 800; // milliseconds
   
    private final List<Point> controlPoints = new ArrayList<>();
    private int currentStep = 0;
    private boolean isAnimating = false;
    private Timer animationTimer;
    private int dragIndex = -1;
   
    public ChaikinAlgorithm() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
       
        // Mouse listener for adding points
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Check if clicking on existing point for dragging
                    dragIndex = findPointAt(e.getX(), e.getY());
                   
                    if (dragIndex == -1) {
                        // Add new point
                        controlPoints.add(new Point(e.getX(), e.getY()));
                        currentStep = 0;
                        repaint();
                    }
                }
            }
           
            @Override
            public void mouseReleased(MouseEvent e) {
                dragIndex = -1;
            }
        });
       
        // Mouse motion listener for dragging points
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragIndex != -1) {
                    controlPoints.set(dragIndex, new Point(e.getX(), e.getY()));
                    repaint();
                }
            }
        });
       
        // Key listener for Enter and Escape
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (controlPoints.isEmpty()) {
                        showMessage("Please draw some points first!");
                    } else {
                        startAnimation();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    clearCanvas();
                }
            }
        });
       
        // Animation timer
        animationTimer = new Timer(ANIMATION_DELAY, e -> {
            currentStep++;
            if (currentStep > MAX_STEPS) {
                currentStep = 0;
            }
            repaint();
        });
    }
   
    private int findPointAt(int x, int y) {
        for (int i = 0; i < controlPoints.size(); i++) {
            Point p = controlPoints.get(i);
            double distance = Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
            if (distance <= POINT_RADIUS * 2) {
                return i;
            }
        }
        return -1;
    }
   
    private void startAnimation() {
        if (!isAnimating) {
            isAnimating = true;
            currentStep = 0;
            animationTimer.start();
        } else {
            isAnimating = false;
            animationTimer.stop();
        }
    }
   
    private void clearCanvas() {
        controlPoints.clear();
        currentStep = 0;
        isAnimating = false;
        animationTimer.stop();
        repaint();
    }
   
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
   
    private List<Point> chaikinStep(List<Point> points) {
        if (points.size() < 2) {
            return new ArrayList<>(points);
        }
       
        List<Point> newPoints = new ArrayList<>();
       
        for (int i = 0; i < points.size() - 1; i++) {
            Point p0 = points.get(i);
            Point p1 = points.get(i + 1);
           
            // Q point: 3/4 of the way from p0 to p1
            int qx = (int) (0.75 * p0.x + 0.25 * p1.x);
            int qy = (int) (0.75 * p0.y + 0.25 * p1.y);
           
            // R point: 1/4 of the way from p0 to p1
            int rx = (int) (0.25 * p0.x + 0.75 * p1.x);
            int ry = (int) (0.25 * p0.y + 0.75 * p1.y);
           
            newPoints.add(new Point(qx, qy));
            newPoints.add(new Point(rx, ry));
        }
       
        return newPoints;
    }
   
    private List<List<Point>> generateAllSteps() {
        List<List<Point>> steps = new ArrayList<>();
        steps.add(new ArrayList<>(controlPoints));
       
        List<Point> current = new ArrayList<>(controlPoints);
        for (int i = 0; i < MAX_STEPS; i++) {
            current = chaikinStep(current);
            steps.add(current);
        }
       
        return steps;
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        // Draw instructions
        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        g2d.drawString("Left Click: Add points | Enter: Start/Stop animation | C: Clear | Esc: Exit", 10, 20);
       
        if (controlPoints.isEmpty()) {
            return;
        }
       
        // Draw control points
        g2d.setColor(new Color(59, 130, 246));
        g2d.setStroke(new BasicStroke(2));
       
        for (int i = 0; i < controlPoints.size(); i++) {
            Point p = controlPoints.get(i);
           
            // Draw circle
            g2d.fill(new Ellipse2D.Double(p.x - POINT_RADIUS, p.y - POINT_RADIUS,
                                          POINT_RADIUS * 2, POINT_RADIUS * 2));
            g2d.setColor(new Color(30, 64, 175));
            g2d.draw(new Ellipse2D.Double(p.x - POINT_RADIUS, p.y - POINT_RADIUS,
                                          POINT_RADIUS * 2, POINT_RADIUS * 2));
           
            // Draw point number
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Arial", Font.BOLD, 10));
            FontMetrics fm = g2d.getFontMetrics();
            String label = String.valueOf(i + 1);
            int labelWidth = fm.stringWidth(label);
            g2d.drawString(label, p.x - labelWidth / 2, p.y + 4);
            g2d.setColor(new Color(59, 130, 246));
        }
       
        // Draw dashed lines between control points
        if (controlPoints.size() > 1) {
            g2d.setColor(new Color(147, 197, 253));
            g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
                                         10, new float[]{5, 5}, 0));
           
            for (int i = 0; i < controlPoints.size() - 1; i++) {
                Point p0 = controlPoints.get(i);
                Point p1 = controlPoints.get(i + 1);
                g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
            }
        }
       
        // Draw Chaikin curve
        if (currentStep > 0 || isAnimating) {
            List<List<Point>> steps = generateAllSteps();
            List<Point> currentPoints = steps.get(Math.min(currentStep, steps.size() - 1));
           
            if (currentPoints.size() > 1) {
                // Draw the refined curve
                g2d.setColor(new Color(16, 185, 129));
                g2d.setStroke(new BasicStroke(3));
               
                for (int i = 0; i < currentPoints.size() - 1; i++) {
                    Point p0 = currentPoints.get(i);
                    Point p1 = currentPoints.get(i + 1);
                    g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
                }
               
                // Draw refined points
                for (Point p : currentPoints) {
                    g2d.fill(new Ellipse2D.Double(p.x - 2, p.y - 2, 4, 4));
                }
            }
        }
       
        // Draw step counter
        if (currentStep > 0 || isAnimating) {
            g2d.setColor(new Color(30, 64, 175));
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String stepText = "Step: " + currentStep + " / " + MAX_STEPS;
            g2d.drawString(stepText, getWidth() - 120, 30);
           
            if (isAnimating) {
                g2d.setColor(new Color(16, 185, 129));
                g2d.drawString("● Animating", getWidth() - 120, 50);
            }
        }
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chaikin's Algorithm Animation");
            ChaikinAlgorithm panel = new ChaikinAlgorithm();
           
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
           
            panel.requestFocusInWindow();
        });
    }
}
