import java.util.*;

public class Level1
{
    public static boolean MisterRobot(int N, int[] data) {
        int index = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (data[i] != (i - 1)) {
                index = (i - 1);
                break;
            }
        }

        int temp = 0;
        while (index >= index - 2) {
            for (int j = index; j > index - 2; j--) {
                if (data[j] < data[j - 1]) {
                    temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                }
            }
            index -= 2;
            if(index == 1) break;
        }

        boolean flag = false;
        for (int k = 0; k < N; k++) {
            if (data[k] != k + 1) {
                flag = false;
                break;
            }
            else flag = true;
        }
        return flag;
    }
}
