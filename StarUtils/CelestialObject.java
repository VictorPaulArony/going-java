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

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CelestialObject that = (CelestialObject) object;

        return Double.compare(that.x, x) == 0 &&
               Double.compare(that.y, y) == 0 &&
               Double.compare(that.z, z) == 0 &&
               name.equals(that.name);

    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        long temp;
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



    public static void main(String[] args) {
        CelestialObject celestialObject = new CelestialObject();
        CelestialObject earth = new CelestialObject("Terre", 1.0, 2.0, 2.0);
        CelestialObject earth1 = new CelestialObject("Terre", 1.0, 2.0, 2.0);

        System.out.println(earth.toString());
        System.out.println(earth.equals(earth1));
        System.out.println(earth.equals(celestialObject));

        System.out.println(earth.hashCode());
        System.out.println(celestialObject.hashCode());
    }
}

// $ javac *.java -d build
// $ java -cp build ExerciseRunner
// Terre is positioned at (1.000, 2.000, 2.000)
// true
// false
// 2129490293
// -1811995559
// $