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
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            // Remove the last line separator if there is one
            if (content.length() > 0) {
                content.setLength(content.length() - System.lineSeparator().length());
            }
            return content.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
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