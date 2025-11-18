import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
       if (list == null) {
        return null;
       }
         if (!list.contains(value)) {
          return null;
         }
       return list.lastIndexOf(value);
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
       if (list == null ) {
        return null;
       }
       if (!list.contains(value)) {
        return null;
       }
       return list.indexOf(value);
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> res = new ArrayList<>();
        if (list == null) {
        return list;
       }
       if (!list.contains(value)) {
        return res;
       }
       for (int i=0; i< list.size(); i++) {
        if (value.equals(list.get(i))){
            res.add(i);
        }
       }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89).toString());
    }
}