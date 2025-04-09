public class DoOp {
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "Error: Expected 3 arguments.";
        }

        try {
            int left = Integer.parseInt(args[0].trim());
            String op = args[1].trim();
            int right = Integer.parseInt(args[2].trim());

            switch (op) {
                case "+":
                    return String.valueOf(left + right);
                case "-":
                    return String.valueOf(left - right);
                case "*":
                    return String.valueOf(left * right);
                case "/":
                    if (right == 0) return "Error: Division by zero.";
                    return String.valueOf(left / right);
                case "%":
                    if (right == 0) return "Error: Modulo by zero.";
                    return String.valueOf(left % right);
                default:
                    return "Error: Invalid operator.";
            }
        } catch (NumberFormatException e) {
            return "Error: Invalid number format.";
        }
    }

    // tester method
    public static void main(String[] args) {
        
        String[] test1 = {"10", "+", "5"};
        String[] test2 = {"10", "/", "0"};
        String[] test3 = {"7", "%", "2"};
        String[] test4 = {"4", "&", "3"};
        
        System.out.println(operate(test1)); // 15
        System.out.println(operate(test2)); // Error: Division by zero.
        System.out.println(operate(test3)); // 1
        System.out.println(operate(test4)); // Error: Invalid operator.
    
    // You can run this class with command-line arguments
    // Example: java DoOp 7 * 3
    String result = operate(args);
    System.out.println(result);
    }
}
