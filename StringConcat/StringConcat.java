public class StringConcat {
    public static String concat(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return null;
        }
        
        if (s1 == null) {
            s1 = "";
        }
        if (s2 == null) {
            s2 = "";
        }
        String res = new StringBuilder(s1).append(s2).toString();
        return res;
    }

    //tester method
    public static void main(String[] args) {
        String s1 = "victor ";
        String s2 = "étudiant !";
        System.out.println(concat(s1,s2));
    }
}