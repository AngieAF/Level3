import java.util.*;

public class Level1
{
    public static int SumOfThe(int N, int [] data) {
        int el;
        int left, right, sum = 0;
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            el = data[i];
            left = i;
            right = data.length - 1 - i;

            for (int j = left - i; j < i; j++)
                sum += data[j];

            for (int k = i + 1; k < data.length; k++)
                sum += data[k];

            System.out.println("Element: " + el);
            System.out.println("Sum: " + sum);
            if (el == sum) {
                result = data[i];
                return result;
            }
            sum = 0;
        }
        return result;
    }
}
