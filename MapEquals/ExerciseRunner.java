import java.util.Map;

public class ExerciseRunner {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map2 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        System.out.println(MapEquals.areMapsEqual(map1, map2)); // Expected Output: true

        Map<String, Integer> map3 = Map.of("Alice", 1, "Bob", 2, "Charly", 3);
        Map<String, Integer> map4 = Map.of("Alice", 1, "Bob", 2, "Emily", 3);
        System.out.println(MapEquals.areMapsEqual(map3, map4)); // Expected Output: false
    }
}