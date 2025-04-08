public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] substrings = s.split("\\|");
        StringBuilder result = new StringBuilder();
        
        for (String substring : substrings) {
            String trimmed = substring.trim();
            int firstDot = trimmed.indexOf('.');
            int lastDot = trimmed.lastIndexOf('.');
            
            // If no dots found, skip this substring
            if (firstDot == -1 || lastDot == -1) {
                continue;
            }
            
            // Extract between first and last dot
            String extracted = trimmed.substring(firstDot + 1, lastDot).trim();
            
            // Only add if we found something between the dots
            if (!extracted.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
       
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
