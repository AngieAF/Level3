import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageFinder {
    public static void main(String[] args) throws IOException {
        String ext1 = ".jpg";
        String ext2 = "png";

        converter(ext1, ext2);
    }

    static void converter(String ext1, String ext2) throws IOException {

        String maindirPath = ".";

        List<File> files = internal(maindirPath, ext1);
        System.out.println(files);

        for(File file: files) {
            BufferedImage img = ImageIO.read(new File(file.getAbsolutePath()));
            Graphics g = img.getGraphics();

            int w = 200, h = 200;
            int x = (img.getWidth()-w)/2;
            int y = (img.getHeight()-h)/2;

            g.fillRect(x, y, w, h);
            g.setColor(Color.BLACK);
            int lineHeight = g.getFontMetrics().getHeight();
            String text = "Hello,\nWorld!";

            for (String line : text.split("\n"))
                g.drawString(line, x + x/2, y += lineHeight);

            g.dispose();

            String fileName = file.getAbsolutePath().replaceFirst("[.][^.]+$", "");
            System.out.println(fileName);
            ImageIO.write(img, ext2, new File(fileName + "." + ext2));

            file.delete();
        }

    }

    static List<File> internal(String dirPath, String ext) {
        File path = new File(dirPath);
        List<File> arr = new ArrayList<File>();

        File[] expand = path.listFiles();

        for(File file : expand) {
            if(file.isFile() && file.getName().contains(ext)) {
                arr.add(file);
            } else if(file.isDirectory()) {
                arr.addAll(internal(file.getAbsolutePath(), ext));
            }
        }
        return arr;
    }
}