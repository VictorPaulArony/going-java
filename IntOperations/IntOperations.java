public class IntOperations {
    public static int addTwoIntegers(int a, int b) {
        return a + b;
    }
    public static int subtractTwoIntegers(int a, int b) {
        return a - b;
    }
    public static int multiplyTwoIntegers(int a, int b) {
        return a * b;
    }
    public static int divideTwoIntegers(int a, int b) {
        if (b == 0){
            throw new ArithmeticException("Division by 0: ");
        }
        return a / b;
    }
    //main method to test 
    public static void main(String[] args) {
        int  a = 10;
        int b = 2;

        System.out.println("Addition: " + addTwoIntegers(a, b));
        System.out.println("Subtraction: " + subtractTwoIntegers(a, b));
        System.out.println("Multiplication: " + multiplyTwoIntegers(a, b));
        System.out.println("Division: "+ divideTwoIntegers(a, b));
    }
   
}