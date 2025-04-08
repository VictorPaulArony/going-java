public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        if (s == null || target == null || replacement == null) {
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
    }
}
