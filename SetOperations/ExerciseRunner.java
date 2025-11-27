
import java.util.HashSet;
import java.util.Set;

public class ExerciseRunner {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> unionSet = SetOperations.union(set1, set2);
        System.out.println(unionSet);

        Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);
        System.out.println(intersectionSet);
    }
}
