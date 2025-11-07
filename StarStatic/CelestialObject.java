public class CelestialObject {
    private double x ;
    private double y;
    private double z ;
    private String name; 

    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String n, double a, double b, double c) {
        this.x = a;
        this.y = b;
        this.z  = c;
        this.name = n;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double dx = obj2.x - obj1.x;
        double dy = obj2.y - obj1.y;
        double dz = obj2.z - obj1.z;
        return Math.sqrt(dx * dx + dy*dy + dz*dz);

    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        return getDistanceBetween(obj1, obj2) * KM_IN_ONE_AU;
    }

}

