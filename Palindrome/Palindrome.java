public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equals(s2);
    }

     //tester method
     public static void main(String[] args) {
        String s1 = "victor";
        String s2 = "omo";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
}