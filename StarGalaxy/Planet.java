import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }
    public Planet(String name, double x, double y, double z, Star centerStar) {  
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return this.centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Planet planet = (Planet) obj;
        return Objects.equals(centerStar, planet.centerStar);
    }
    @Override
    public String toString() {
        double dwithcenterstar = CelestialObject.getDistanceBetween(this, this.centerStar);
        return String.format("%s circles around %s at the %.3f AU", this.getName(),this.centerStar.getName(),dwithcenterstar);
    }
}