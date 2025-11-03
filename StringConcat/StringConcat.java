public class StringConcat {
    public static String concat(String s1, String s2) {
       return s1.concat(s2);
    }

    public static void main(String[] args) {
        System.out.println(StringConcat.concat("Hello ", "étudiant !"));
        System.out.println(StringConcat.concat("", "Hello World !"));
    }
}