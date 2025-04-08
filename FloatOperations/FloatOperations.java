public class FloatOperations{
    public static float addTwoFloats(float a, float b){
        return a + b;
    }
    public static float divideTwoFloats(float a, float b){
        if (b == 0.0) {
            throw new ArithmeticException("Division by 0.0: ");
        }
        return a / b;
    }

    public static void main(String[] args) {

        float a = 10.0f;
        float b = 2.0f;

        System.out.println("Addition: " + addTwoFloats(a,b));
        System.out.println("Division: " + divideTwoFloats(a, b));

    }
}