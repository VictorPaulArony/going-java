public class StringLength {
    public static int getStringLength(String s){
        return s.length();
    }

    public static void main(String[] args) {
        String s = "Victor Paul Arony";
        System.out.println("String length : " + getStringLength(s));
    }
}