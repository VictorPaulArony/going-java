import java.util.Set;
import java.util.TreeSet;

public class ExerciseRunner {

    public static void main(String[] args) {
        Set<String> set1 = new TreeSet<>();
        set1.add("Alice");
        set1.add("Bob");
        set1.add("Charly");

        Set<String> set2 = new TreeSet<>();
        set2.add("Bob");
        set2.add("Charly");
        set2.add("Alice");

    

        System.out.println(SetEquals.areSetsEqual(null, set1)); // Expected Output: false
    }
}