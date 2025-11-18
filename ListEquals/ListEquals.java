import java.util.List;

public class ListEquals {
    public static boolean areListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        for(int i=0; i < list1.size(); i++) {
                if(!list1.get(i).equals(list2.get(i))) {
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Charly", "Emily")));
        System.out.println(ListEquals.areListsEqual(List.of("Alice", "Bob", "Charly", "Emily"), List.of("Alice", "Bob", "Emily", "Charly")));
    }
}