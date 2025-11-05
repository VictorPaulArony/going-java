import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];
        String content = new String(Files.readAllBytes(Paths.get(inputFile)));
        
        String[] words = content.split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                if (word.length() == 1) {
                    result.append(word.toUpperCase());
                } else {
                    result.append(Character.toUpperCase(word.charAt(0)))
                          .append(word.substring(1).toLowerCase());
                }
            }
        }
        
        Files.write(Paths.get(outputFile), result.toString().getBytes());
    }

    public static void main(String[] args) throws IOException {
        Capitalize.capitalize(new String[] { "input", "output" });
        String expectedResult = new String(Files.readAllBytes(Paths.get("result")));
        String userOutput = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(expectedResult.equals(userOutput));
    }
}