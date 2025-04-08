public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            part = part.trim();
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            if (firstDot != -1 && lastDot != -1 && firstDot < lastDot) {
                part = part.substring(firstDot + 1, lastDot).trim();
            }

            if (!part.isEmpty()) {
                result.append(part).append(" ");
            }
        }

        return result.toString().trim();
    }
}
