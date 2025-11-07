import java.util.Objects;
public class CelestialObject{
    private static final double EPSILON = 1e-9;
    public double x;
    public double y;
    public double z;
    public String name;
    public static final double KM_IN_ONE_AU = 150000000.0;

    public CelestialObject(){
        x=0.0;
        y=0.0;
        z=0.0;
        name="Soleil";
    }

    public CelestialObject(String name,double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
        this.name=name;
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
}