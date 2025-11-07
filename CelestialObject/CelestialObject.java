public class CelestialObject {
    public double x;
    public double y;
    public double z;
    public String name;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = null;
    }

    public static void main(String[] args) {
        CelestialObject celestialObject = new CelestialObject();
        System.out.println(celestialObject.x);
        System.out.println(celestialObject.y);
        System.out.println(celestialObject.z);
        System.out.println(celestialObject.name);
    }
}

