import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        double num1;
        double num2;
        String operator;
        double res;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First number: ");
        num1 = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Enter Operator(+, -, /, *, % ): ");
        operator = scanner.nextLine().trim();

        System.out.print("Enter Second number: ");
        num2 = scanner.nextDouble();

        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: Division by zero");
                    scanner.close();
                    return;
                }
                res = num1 / num2;
                break;
            case "%":
                res = num1 % num2;
                break;
            default:
                System.out.printf("Invalid Operator: %s \n", operator);
                scanner.close();
                return;
        }
        System.out.printf("Results: %.2f\n", res);

        scanner.close();
    }
}
