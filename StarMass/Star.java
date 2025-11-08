import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;
    private int mass;
    public Star() {
        super();
        this.magnitude = 0.0;
        this.mass=0;
    }

    public Star(String name, double x, double y, double z, double magnitude,int mass) {
        super(name, x, y, z,0);
        this.magnitude = magnitude;
        this.mass=mass;
    }

    public int getMass() {
        return this.mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }


    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Star star = (Star) obj;
        return Double.compare(star.magnitude, magnitude) == 0
        && Double.compare(star.getX(), getX()) == 0
        && Double.compare(star.getY(), getY()) == 0
        && Double.compare(star.getZ(), getZ()) == 0
        && Objects.equals(star.getName(), getName());
    }

   @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY(), getZ(), magnitude);
    }

    @Override 
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
    }
}