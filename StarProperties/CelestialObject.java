public class CelestialObject {
    public double x ;
    public double y;
    public double z ;
    public String name ; 

    public CelestialObject() {
        x = 0.0;
        y = 0.0;
        z = 0.0;
        name = "Soleil";
    }

    public CelestialObject(String n, double a, double b, double c) {
        x = a;
        y = b;
        z = c;
        name = n;

    }

    public static void main(String[] args) {
        CelestialObject defaultStar = new CelestialObject();
        System.out.println(defaultStar.x);
        System.out.println(defaultStar.y);
        System.out.println(defaultStar.z);
        System.out.println(defaultStar.name);

        CelestialObject earth = new CelestialObject("Terre", 0.43, 0.98, 1.43);
        System.out.println(earth.x);
        System.out.println(earth.y);
        System.out.println(earth.z);
        System.out.println(earth.name);
    }
}