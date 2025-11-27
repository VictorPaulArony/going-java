
import java.io.File;

public class FileSearch {

    public static String search(String current, String fileName) {
        File dir = new File(current);

        if (!dir.exists()) {
            return null;
        }

        if (dir.isDirectory()) {
            String[] entries = dir.list();
            if (entries != null) {
                for (String entry : entries) {
                    if (entry.equals(fileName)) {
                        return current + File.separator + fileName;
                    }
                    String path = search(current + File.separator + entry, fileName);
                    if (path != null) {
                        return path;
                    }
                }
            }
        }

        return null;
    }

    public static String searchFile(String fileName) {
        return FileSearch.search("documents", fileName);
    }

}
