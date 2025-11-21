
public class Excalibur {
    private static Excalibur INSTANCE;
    private static String name;

    private Excalibur(String name) {
        this.name = name;
    }

    public static String getName() {
        return name;
    }

    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            new Excalibur("Sword");
        }
        return INSTANCE;
    }
}