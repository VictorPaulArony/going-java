public class StringConcat {
    public static String concat(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return null;
        }
        if(s1 == null ) {
            s1 = "";
        }
        if (s2 == null) {
            s2 = "";
        }
       return s1.concat(s2);
    }

    public static void main(String[] args) {
        System.out.println(StringConcat.concat("Hello ", "étudiant !"));
        System.out.println(StringConcat.concat("", "Hello World !"));
    }
}