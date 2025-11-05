import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }

        String inFile = args[0];
        String outFile = args[1];
        try (InputStream in = new FileInputStream(inFile); FileWriter writer = new FileWriter(outFile)){
            byte[] buff = new byte[1024];
            int b;
            while((b = in.read(buff)) != -1) {
                writer.write(new String(buff, 0, b));
            }
            
        } catch (Exception e) {
           return ;
        }
    }

    public static void main(String[] args) throws IOException {
        Capitalize.capitalize(new String[]{"input", "output"});
        String expectedResult = new String(Files.readAllBytes(Paths.get("result")));
        String userOutput = new String(Files.readAllBytes(Paths.get("output")));
        System.out.println(expectedResult.equals(userOutput));
    }
}