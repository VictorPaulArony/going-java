import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        // Check if a filename is provided
        if (args == null || args.length == 0) {
            return; // No file to read, exit silently
        }

        String fileName = args[0];
        File file = new File(fileName);

        // Check if the file exists and is readable
        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return; // Exit silently if the file cannot be read
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[1024]; // Read in chunks of 1024 bytes
            int bytesRead;

            // Read the file in chunks and write to standard output
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle any IO exceptions silently
            return;
        }
    }
}