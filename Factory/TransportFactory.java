
public class TransportFactory {
    public static int getTransport(String s) {
        if (s.equals("Car")) {
            return 600;
        } else if (s.equals("Plane")) {
            return 10000;
        }
        return 0;
    }
}