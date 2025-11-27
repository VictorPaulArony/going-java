
import java.util.HashSet;
import java.util.Set;

public class SetOperations {

    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {

        if (set1 == null && set2 == null) {
            return null;
        }
        if (set1 == null) {
            return new HashSet<>(set2);
        }
        if (set2 == null) {
            return new HashSet<>(set1);
        }
        Set<Integer> s = new HashSet<>(set1);
        s.addAll(set2);
        return s;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set2 == null) {
            return null;
        }
        Set<Integer> s = new HashSet<>(set1);
        s.retainAll(set2);
        return s;
    }
}
