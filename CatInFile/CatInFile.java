import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        String file = args[0];

        try (InputStream input = System.in; OutputStream out = new FileOutputStream(file)) {
            int b;
            while ((b = input.read()) != -1) {
                out.write(b); 
            }
        } catch (Exception e) {
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        String input = "input file test\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        CatInFile.cat(new String[] { "output" });
        String fileContent = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(fileContent.equals(input));
    }
}