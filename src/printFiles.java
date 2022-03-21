import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class printFiles {
    public static List<String> printFiles(String path) {
        File[] files = new File(path).listFiles();
        LinkedList<String> filesList = new LinkedList<>();
        if (files == null) {
            return filesList;
        }
        for (File file : files) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                filesList.addAll(printFiles(path + fileName + "/"));
            } else {
                filesList.add(fileName);
            }
        }
        return filesList;
    }
}
