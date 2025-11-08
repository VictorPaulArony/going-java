import java.util.Objects;
public class Star extends CelestialObject{
    private double magnitude;

    public void setMagnitude(double magnitude){
        this.magnitude=magnitude;
    }

    public double getMagnitude(){
        return this.magnitude;
    }

    public Star(String name,double x,double y,double z,double magnitude){
        super(name,x,y,z);
        this.magnitude=magnitude;
    }
    public Star(){
        super();
        this.magnitude=0.0;
    }

    public String toString(){
        return String.format("%s shines at the %.3f magnitude",super.name,this.magnitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,x,y,z,magnitude);
    }

    public boolean equals(Star obj2) {
        if (obj2 == null) return false;
        if (this.getClass() != obj2.getClass()) return false;

        return this.x == obj2.x &&
           this.y == obj2.y &&
           this.z == obj2.z &&
           this.magnitude == obj2.magnitude &&
           this.name.equals(obj2.name);
    }

    public static void main(String[] args) {
        Star star = new Star();
        Star star2 = new Star();

        CelestialObject s =new CelestialObject();
        
        
        System.out.println(star.equals(s));

        Star proxima = new Star("Proxima", 18.389, 832.32, 218, 0.4);
        
        System.out.println(star.toString());
        System.out.println(proxima.toString());
        System.out.println(star.equals(star2));
        System.out.println(star.equals(proxima));
    }
}