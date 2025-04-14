public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super(); // Call the default constructor of CelestialObject
        this.magnitude = 0.0;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
}