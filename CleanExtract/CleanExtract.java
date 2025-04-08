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
            
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                String extracted = trimmed.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
       
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
