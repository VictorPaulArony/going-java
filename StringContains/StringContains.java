public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        if (subString == null || s == null) {
            return false;
        }
        return s.contains(subString);
    }

    //tester
    public static void main(String[] args) {
        String subString = "hell";
        String s = "hello";

        String s1 = "Bonjour";
        String s2 = "hello World !";

        System.out.println(isStringContainedIn(subString, s));
        System.out.println(isStringContainedIn(s1, s2));
    }
}