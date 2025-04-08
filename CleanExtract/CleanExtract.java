public class CleanExtract {
    public static String extract(String s) {
        // Split the input string by the '|' character
        String[] substrings = s.split("\\|");

        // StringBuilder to build the final result
        StringBuilder result = new StringBuilder();

        for (String substring : substrings) {
            // Find the first and last '.' in the substring
            int firstDot = substring.indexOf('.');
            int lastDot = substring.lastIndexOf('.');

            // Extract the portion between the first and last '.'
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String extracted = substring.substring(firstDot + 1, lastDot).trim();
                // Append the extracted string to the result with a space
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
