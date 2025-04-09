import java.io.*;
import java.nio.file.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Both input and output file paths are required");
        }

        String inputFile = args[0];
        String outputFile = args[1];

        // Read all lines from input file
        String content = new String(Files.readAllBytes(Paths.get(inputFile)));
        
        // Capitalize each word
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
        
        // Write result to output file
        Files.write(Paths.get(outputFile), result.toString().getBytes());
    }
}