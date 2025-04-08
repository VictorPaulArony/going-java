public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
      // Split the input string by the '|' character
      String[] substrings = s.split("\\|");

      StringBuilder result = new StringBuilder();

      for (String substring : substrings) {
          // Trim leading and trailing whitespace from the substring
          substring = substring.trim();

          // Find the index of the first '.' and the last '.'
          int firstDotIndex = substring.indexOf('.');
          int lastDotIndex = substring.lastIndexOf('.');

          // If both '.' exist and are not the same, extract the portion between them
          if (firstDotIndex != -1 && lastDotIndex != -1 && firstDotIndex < lastDotIndex) {
              String extracted = substring.substring(firstDotIndex + 1, lastDotIndex).trim();
              if (!extracted.isEmpty()) {
                  // Append the cleaned substring to the result
                  if (result.length() > 0) {
                      result.append(" ");
                  }
                  result.append(extracted);
              }
          }
      }

      // Return the final cleaned and joined string
      return result.toString();
    }

    public static void main(String[] args) {
       
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
