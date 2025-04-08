public class IsEven {
    public static boolean isEven(int a) {
        if (a%2 == 0) {
            return true;
        }
        return false;
    }

    //tester method main
    public static void main(String[] args) {
        int a = 19;
        int b = 20;
        System.out.println(isEven(a));
        System.out.println(isEven(b));
    }

}