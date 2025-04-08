public class StringConcat {
    public static String concat(String s1, String s2) {
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