public class PerfectNumber {
    public boolean isPerfectNumber(int number) {
        int sum =0;
        for (int i= 1; i < number;i++) {
            if (number%i == 0){
                sum += i;
            }
        }
        if (sum == number) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PerfectNumber perfectNumber = new PerfectNumber();

        int number1 = 6;
        System.out.println("Is " + number1 + " a perfect number? " + perfectNumber.isPerfectNumber(number1));

        int number2 = 28;
        System.out.println("Is " + number2 + " a perfect number? " + perfectNumber.isPerfectNumber(number2));

        int number3 = 16;
        System.out.println("Is " + number3 + " a perfect number? " + perfectNumber.isPerfectNumber(number3));
    }
}
