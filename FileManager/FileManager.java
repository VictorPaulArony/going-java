import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    /**
     * Creates a file with the specified name and content.
     * 
     * @param fileName the name of the file to create
     * @param content the content to write to the file
     * @throws IOException if an I/O error occurs
     */
    public static void createFile(String fileName, String content) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    /**
     * Returns the content of the specified file.
     * 
     * @param fileName the name of the file to read
     * @return the content of the file as a String
     * @throws IOException if an I/O error occurs
     */
    public static String getContentFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
        }
        return content.toString();
    }
    
    /**
     * Deletes the specified file.
     * 
     * @param fileName the name of the file to delete
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}