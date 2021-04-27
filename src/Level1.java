import java.util.*;

public class Level1
{
    public static int [] UFO(int N, int [] data, boolean octal) {
        int[] fin = new int[data.length];
        if (octal) {
            for (int i = 0; i < data.length; i++) {
                int k = 0, digit = 0, decimal = 0;
                while (data[i] != 0) {
                    int temp = data[i] % 10;
                    digit = temp * (int) Math.pow(8, k);
                    decimal += digit;
                    data[i] = data[i] / 10;
                    k++;
                }
                fin[i] = decimal;
            }
            return fin;

        } else {
            for (int i = 0; i < data.length; i++) {
                int k = 0, digit = 0, decimal = 0;
                while (data[i] != 0) {
                    int temp = data[i] % 10;
                    digit = temp * (int) Math.pow(16, k);
                    decimal += digit;
                    data[i] = data[i] / 10;
                    k++;
                }
                fin[i] = decimal;
            }
            return fin;
        }
    }
}
