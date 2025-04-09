import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    // Function to create a file with the specified name and content
    public static void createFile(String fileName, String content) throws IOException {
        // Write the content to the file using Files.write
        Files.write(Paths.get(fileName), content.getBytes());
    }

    // Function to retrieve the content of a file
    public static String getContentFile(String fileName) throws IOException {
        // Check if the file exists
        File file = new File(fileName);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }

        // Read the content of the file using Files.readAllBytes
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    // Function to delete a file
    public static void deleteFile(String fileName) {
        // Delete the file using File.delete
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}