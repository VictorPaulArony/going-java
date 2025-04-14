public class CelestialObject {
    private double x ;
    private double y;
    private double z ;
    private String name ; 

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String n, double a, double b, double c) {
        this.x = a;
        this.y = b;
        this.z = c;
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

    public static void main(String[] args) {
        CelestialObject defaultStar = new CelestialObject();
        System.out.println(defaultStar.getX());
        System.out.println(defaultStar.getY());
        System.out.println(defaultStar.getZ());
        System.out.println(defaultStar.getName());

        defaultStar.setName("Terre");
        defaultStar.setX(0.43);
        defaultStar.setY(0.98);
        defaultStar.setZ(1.43);
        System.out.println(defaultStar.getX());
        System.out.println(defaultStar.getY());
        System.out.println(defaultStar.getZ());
        System.out.println(defaultStar.getName());
    }
}