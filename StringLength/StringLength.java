public class StringLength {
    public static int getStringLength(String s) {

       return s.length();
    }

    public static void main(String[] args) {
        System.out.println(StringLength.getStringLength("Hello World !"));
        System.out.println(StringLength.getStringLength(""));
    }
}