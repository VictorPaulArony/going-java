import java.util.Arrays; // Import the Arrays class from java.util

public class SortArgs {
    public static void sort(String[] args) {
        // Validate the input: must not be null
        if (args == null || args.length == 0) {
            System.out.println();
            return;
        }

        try {
            // Convert the array of strings to an array of integers
            int[] numbers = Arrays.stream(args)
                                  .mapToInt(Integer::parseInt)
                                  .toArray();

            // Sort the array of integers
            Arrays.sort(numbers);

            // Build the output string with space-separated numbers
            StringBuilder result = new StringBuilder();
            for (int number : numbers) {
                result.append(number).append(" ");
            }

            // Remove the trailing space and append a newline character
            if (result.length() > 0) {
                result.setLength(result.length() - 1); // Remove the last space
            }
            result.append("\n");

            // Print the result
            System.out.print(result.toString());
        } catch (NumberFormatException e) {
            // Handle invalid number format (though the problem states all inputs are valid numbers)
            System.out.println();
        }
    }
}