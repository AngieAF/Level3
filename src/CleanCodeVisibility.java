import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CleanCodeVisibility {

    for(int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] += 1;
        }
        -- >; В случае с переменной-счетчиком i связывание происходит во время написания кода по причине того,
        что i – это временная переменная, используется в течение короткого времени и имеет область видимости,
        ограниченную циклом.
    }

    public static boolean whiteWalkerDetector(int num, String village, int s, int num_pos, int counter) {
        final int TEMPERATURE_DROP = 10;
        final int WALKERS_COUNT = 3;
        if((Integer.parseInt(String.valueOf(num)) +
                Integer.parseInt(String.valueOf(village.charAt(s))) == TEMPERATURE_DROP)) {
            for(int i = s - 1; i > num_pos; i--) {
                if(village.charAt(i) == '=')
                    counter++;
            }
            if(counter != WALKERS_COUNT) return false;
            counter = 0;
        }
        return true;
    } --> Переменные константы TEMPERATURE_DROP и WALKERS_COUNT связываются на момент компиляции кода,
    в таком случае мы повышаем гибкость программы и избегаем использование “магических чисел“.

    static int calculator(int fileNum1, int fileNum2) throws IOException {

        int[] fileNumArr = new int[] {fileNum1, fileNum2};
        int total = 0;

        for(int i = 0; i < 2; i++) {
            String fileName = "/Users/angiea/IdeaProjects/Basics2/src/Test/" + fileNumArr[i] + ".txt";
            System.out.println(fileName);

            try {
                FileReader my_file = new FileReader(fileName);
                BufferedReader br = new BufferedReader(my_file);

                String st = br.readLine();
                int sum = 0;

                for(int j = 0; j < 3; j++) {
                    sum = sum + Integer.valueOf(st);
                    st = br.readLine();
                }
                br.close();
                total += sum;

            } catch(Exception err) {
                err.printStackTrace();
            }
        }

        return total;
    } --> Инициализация переменной st происходит во время считывания программой файла с данными,
    в данном случае связывание программы происходит во время выполнения программы. Так же происходит,
    когда пользователь вводит данные с клавиатуры.
    
}
