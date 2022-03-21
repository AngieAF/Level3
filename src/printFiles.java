import java.io.File;

public class printFiles {
    private void printFiles(String path) {
        File[] files = new File(path).listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                printFiles(path + fileName + "/");
            } else {
                System.out.println(fileName);
            }
        }
    }
}
