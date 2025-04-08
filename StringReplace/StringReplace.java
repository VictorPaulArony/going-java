public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        if (s == null || target == null || replacement == null) {
            return s; 
        }
        return s.replace(target, replacement);
    }

    public static String replace(String s, char target, char replacement) {
        if (s == null) {
            return s;
        }
        return s.replace(target, replacement);
    }

    // tester
    public static void main(String[] args) {
        String s = "victor is fun. Arony is powerful.";
        String target = "victor";
        String replacement = "Arony";

        String result = replace(s, target, replacement);
        System.out.println(result); 
        System.out.println(replace("javatpoint is a very good website", 'a', 'e'));
    }
}
