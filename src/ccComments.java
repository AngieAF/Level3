import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ccComments {
    public static void main(String[] args) throws IOException {
        // Создаем массив файлов для добавления в архив - информативный
        String[] arrFiles = {"test2.rtf"};
        fileAdd("src/jewelry.zip", arrFiles);
    }

    static void fileAdd(String archiveName, String[] files) throws IOException {
        // Открываем поток архива,  в который хотим добавить файлы - прояснение
        ZipInputStream inputStream = new ZipInputStream(new FileInputStream(archiveName));

        // создаем временный файл - прояснение
        File f = File.createTempFile("temp", ".zip", new File("/Users/angiea/IdeaProjects" +
                "/Basics2/src"));
        // Открываем поток временного архива - прояснение
        ZipOutputStream append = new ZipOutputStream(new FileOutputStream(f));

        // Вызываем функцию для копирования данных из изначального архива во временный - информативный
        fileCopy(inputStream, append);

        // Добавляем файлы во временный архив - - прояснение
        for (String file : files) { // ходим по массиву файлов - прояснение
            ZipEntry zipEntry1 = new ZipEntry(file); // берем файл из массива - прояснение
            System.out.println("Append: " + zipEntry1.getName());

            append.putNextEntry(zipEntry1); // добавляем его заголовок во временный архив - прояснение
            append.write("42\n".getBytes()); // пишем сам файл во временный архив - прояснение
        }
        // закрываем потоки - информативный
        inputStream.closeEntry();
        inputStream.close();
        append.closeEntry();
        append.close();

        // Открываем поток архива для считывания данных (временный архив) - прояснение
        ZipInputStream input = new ZipInputStream(new FileInputStream(f));
        // Открываем поток для копирования данных (изначальный архив) - прояснение
        ZipOutputStream output = new ZipOutputStream(new FileOutputStream(archiveName));

        // Вызываем функцию для копирования данных из временного архива в изначальный архив - прояснение
        fileCopy(input, output);

        // удаляем временный архив – его функция выполнена - прояснение
        f.delete();

        // закрываем потоки - информативный
        input.closeEntry();
        input.close();
        output.closeEntry();
        output.close();

    }

    // функция копирования данных из одного архива в другой - информативный
    static void fileCopy(ZipInputStream inputStream, ZipOutputStream append) throws IOException {
        ZipEntry zipEntry = inputStream.getNextEntry(); // Берем файл/каталог из архива - прояснение
        while (zipEntry != null) { // Продолжаем до конца архива - прояснение
            System.out.println("copy: " + zipEntry.getName());
            append.putNextEntry(zipEntry); // добавляем заголовок в архив - прояснение

            if (!zipEntry.isDirectory()) { // в случае файла копируем его содержимое в выходной архив - прояснение
                int length;
                byte[] buffer = new byte[1024];
                while ((length = inputStream.read(buffer)) > 0) {
                    append.write(buffer, 0, length);
                }
            }
            zipEntry = inputStream.getNextEntry(); // Берем следующий файл/каталог из архива - прояснение

        }
    }
}
