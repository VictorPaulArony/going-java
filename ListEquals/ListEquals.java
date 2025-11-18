import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        if (list1 == null || list2 == null) {
            return false;
        }

        if (list1.equals(list2)) {
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Emily", "Charly")));
    }
}