public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.toLowerCase();
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equals(s2);
    }

     //tester method
     public static void main(String[] args) {
        String s1 = "victor";
        String s2 = "omo";
        String s3 = "AbBa";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3)); // true
    }
}