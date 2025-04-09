public class DoOp {
    public static String operate(String[] args) {
        // Validate the input: must have exactly 3 arguments
        if (args == null || args.length != 3) {
            return "Error";
        }

        // Parse the left operand, operator, and right operand
        String leftOperand = args[0];
        String operator = args[1];
        String rightOperand = args[2];

        try {
            // Convert operands to integers
            int left = Integer.parseInt(leftOperand);
            int right = Integer.parseInt(rightOperand);

            // Perform the operation based on the operator
            switch (operator) {
                case "+":
                    return String.valueOf(left + right);
                case "-":
                    return String.valueOf(left - right);
                case "*":
                    return String.valueOf(left * right);
                case "/":
                    if (right == 0) {
                        return "Error"; // Division by zero
                    }
                    return String.valueOf(left / right);
                case "%":
                    if (right == 0) {
                        return "Error"; // Modulo by zero
                    }
                    return String.valueOf(left % right);
                default:
                    return "Error"; // Invalid operator
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            return "Error";
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
