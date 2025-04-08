public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');
            
            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                // Extract between first and last dot
                String clean = part.substring(firstDot + 1, lastDot).trim();
                if (!clean.isEmpty()) {
                    result.append(clean).append(" ");
                }
            }
        }

        // Remove trailing space
        return result.toString().trim();
    }
}
