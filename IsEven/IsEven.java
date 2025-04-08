public class IsEven {
    public static boolean IsEven(int a) {
        if (a%2 == 0) {
            return true;
        }
        return false;
    }

    //tester method main
    public static void main(String[] args) {
        int a = 19;
        int b = 20;
        System.out.println(IsEven(a));
        System.out.println(IsEven(b));
    }

}