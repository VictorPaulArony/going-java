public class IsEven {
    public static boolean isEven(int a) {
        if(a%2==0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(IsEven.isEven(2));
        System.out.println(IsEven.isEven(26));
        System.out.println(IsEven.isEven(57));
    }
}