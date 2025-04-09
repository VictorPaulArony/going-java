import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        Path path = Paths.get(fileName);
        Files.writeString(path, content);  // Using writeString for better text handling
    }

    public static String getContentFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readString(path);  // Using readString for consistent text reading
    }

    public static void deleteFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.deleteIfExists(path);
    }
}