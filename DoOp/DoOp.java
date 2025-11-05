public class DoOp {
    private static final  String ERROR = "Error";
    public static String operate(String[] args) {
        if (args.length != 3) {
            return "it depend on the input.";
        }
        String str1 = args[0];
        String op = args[1];
        String str2 = args[2];

        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        switch (op) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "%":
                if (num2 == 0) {
                    return ERROR;
                }
                return String.valueOf(num1 % num2);
            case "/":
                if (num2 == 0) {
                    return ERROR;
                }
                return String.valueOf(num1 / num2);
            default:
                return ERROR;
        }
    }

    public static void main(String[] args) {
        System.out.println(DoOp.operate(new String[] { "1", "+", "2" }));
        System.out.println(DoOp.operate(new String[] { "1", "-", "1" }));
        System.out.println(DoOp.operate(new String[] { "1", "%", "0" }));
        System.out.println(DoOp.operate(args));
    }
}