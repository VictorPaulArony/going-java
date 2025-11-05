import java.io.*;

public class Cat {
   public static void cat(String[] args) throws IOException {
        // Check if a filename is provided
        if (args == null || args.length == 0) {
            return; 
        }

        String fileName = args[0];
        File file = new File(fileName);

        if (!file.exists() || !file.isFile() || !file.canRead()) {
            return; 
        }

        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[1024]; 
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        PrintStream stdout = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Cat.cat(new String[]{"input.txt"});
        String output = outputStream.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output.equals("test input file\n"));

        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
        PrintStream printStream2 = new PrintStream(outputStream2);
        System.setOut(printStream2);

        Cat.cat(new String[]{});
        String output2 = outputStream2.toString();
        // Reset out to stdout
        System.setOut(stdout);
        System.out.println(output2.equals(""));
    }
}