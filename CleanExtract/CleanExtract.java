public class CleanExtract {
    public static String extract(String s) {
        StringBuilder returnString = new StringBuilder();
        String[] splitStrings = s.split("\\|");
        for (int i = 0; i < splitStrings.length; i++) {
            int startDot = splitStrings[i].indexOf('.');
            int endDot = splitStrings[i].lastIndexOf('.');
            if (startDot != -1 && endDot != -1 && startDot < endDot) {
                String extracted = splitStrings[i].substring(startDot + 1, endDot).trim();
                if (!extracted.isEmpty()) {
                    returnString.append(extracted).append(" ");
                }
            } else if (startDot != -1) {
                String extracted = splitStrings[i].substring(startDot + 1).trim();
                if (!extracted.isEmpty()) {
                    returnString.append(extracted).append(" ");
                }
            } else {
                String extracted = splitStrings[i].trim();
                if (!extracted.isEmpty()) {
                    returnString.append(extracted).append(" ");
                }
            }
        }

        return returnString.toString().trim();
    }

    public static void main(String[] args) {
       
        System.out.println(CleanExtract.extract("The|. quick brown. | what do you ..| .fox .|. Jumps over the lazy dog. ."));
        System.out.println(CleanExtract.extract("  | Who am .I  | .love coding,  |  |.  Coding is fun . | ...  "));
    }
}
