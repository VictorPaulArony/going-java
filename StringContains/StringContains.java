public class StringContains {
    public static boolean isStringContainedIn(String subString, String s) {
        return s.contains(subString);
    }

    public static void main(String[] args) {
        System.out.println(StringContains.isStringContainedIn("Hell", "Highway to Hell"));
        System.out.println(StringContains.isStringContainedIn("Hell", "Hello World !"));
        System.out.println(StringContains.isStringContainedIn("Bonjour", "hello World !"));
    }
}