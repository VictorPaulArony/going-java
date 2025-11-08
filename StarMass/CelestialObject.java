import java.util.Objects;
public class CelestialObject{
    private static final double EPSILON = 1e-9;
    public double x;
    public double y;
    public double z;
    public String name;
    private int mass;
    public static final double KM_IN_ONE_AU = 150000000.0;

    public CelestialObject(){
        x=0.0;
        y=0.0;
        z=0.0;
        name="Soleil";
    }

    public CelestialObject(String name,double x,double y,double z,int mass){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
        this.mass=mass;
    }

    public int getMass() {
        return this.mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setX(double x){
        this.x=x;
    }

    public void setY(double y){
        this.y=y;
    }

    public void setZ(double z){
        this.z=z;
    }

    public void setName(String name){
        this.name=name;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    public String getName(){
        return this.name;
    }

    public static double getDistanceBetween(CelestialObject obj1,CelestialObject obj2){
      return Math.sqrt(Math.pow(obj2.x-obj1.x,2)+Math.pow(obj2.y-obj1.y,2)+Math.pow(obj2.z-obj1.z,2));
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1,CelestialObject obj2){
        return getDistanceBetween(obj1,obj2)*CelestialObject.KM_IN_ONE_AU;
    }

    public String toString(){
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)",this.name,this.x,this.y,this.z);
    }

    public boolean equals( CelestialObject obj2) {
    if (obj2 == null) return false;
    return hashCode()==obj2.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,x,y,z);
    }

       public static void main(String[] args) {
        Galaxy galaxy = new Galaxy();
        CelestialObject charron = new CelestialObject("Charron", -123.12, 392.238, 32.31, 157);
        CelestialObject lune = new CelestialObject("Lune", 3928.32, 327.239, -12.92, 3987);
        Star betelgeuse = new Star("Betelgeuse", 128.23, -12.82, 32.328, 1289.3, 538595);
        Star altair = new Star("Betelgeuse", 43894.34, -324.43, 9438.23, 123.54, 137273);
        Star bellatrix = new Star("Bellatrix", 584.34, 2103.32, -102.43, 413.2, 5483724);
        Planet naboo = new Planet("Naboo", 17.4389, 8349.1, 8943.92, betelgeuse, 32454);
        Planet tatooine = new Planet("Tatooine", 17.4389, 8349.1, 8943.92, betelgeuse, 2345);
        Planet mercure = new Planet("Mercure", 17.4389, 8349.1, 8943.92, altair, 19438);
        Planet venus = new Planet("Venus", 17.4389, 8349.1, 8943.92, altair, 9283);
        Planet mars = new Planet("Mars", 17.4389, 8349.1, 8943.92, altair, 2183);
        
        galaxy.addCelestialObject(lune);
        galaxy.addCelestialObject(charron);
        galaxy.addCelestialObject(mars);
        galaxy.addCelestialObject(mercure);
        galaxy.addCelestialObject(tatooine);
        galaxy.addCelestialObject(altair);
        galaxy.addCelestialObject(venus);
        galaxy.addCelestialObject(betelgeuse);
        galaxy.addCelestialObject(naboo);
        galaxy.addCelestialObject(bellatrix);
        
        System.out.println(galaxy.computeMassRepartition().toString());
    }

}