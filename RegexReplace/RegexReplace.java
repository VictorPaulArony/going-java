public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null)
            return null;
return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }

    public static String obfuscateEmail(String s) {
        if (s == null)
            return null;
        String[] arr = s.split("@");
        StringBuilder ss = new StringBuilder(arr[0]);

        boolean a = arr[0].contains("-") || arr[0].contains(".") || arr[0].contains("_");
        boolean b = false;
        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);
            if (a) {
                if (b) {
                    ss.setCharAt(i, '*');
                }
                if (c == '.' || c == '-' || c == '_') {
                    b = true;
                }

            } else {
                if (i > 2) {
                    ss.setCharAt(i, '*');
                }
            }
        }
        if (arr.length == 2) {

            String[] ar = arr[1].split("\\.");

            ar[0] = ar[0].replaceAll(".", "*");

            if (ar.length == 3) {
                ar[2] = ar[2].replaceAll(".", "*");
            } else if (ar.length == 2) {
                if (!ar[1].equals("com") && !ar[1].equals("net") && !ar[1].equals("org")) {
                    ar[1] = ar[1].replaceAll(".", "*");
                }
            }

            return ss.toString() + "@" + String.join(".", ar);
        }

        return ss.toString();
    }

}