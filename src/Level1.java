import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        boolean flag = false;
        int j = 0, counter = 0, sp = 0;
        for (int i = 0; i < S1.length(); i++) {
            if(counter == W1) break;

            if (S1.charAt(i) == ' ') sp++;
            else {
                if (S2.charAt(j) == ' ' && flag == true) {
                    j++;
                    i = i + j - sp;
                }
                if (S2.charAt(j) == S1.charAt(i)) {
                    j++;
                    flag = true;
                    counter++;
                } else {
                    flag = false;
                    i = i - counter - sp;
                    j = 0;
                    counter = 0;
                    sp = 0;
                }
            }

        }
        return flag;
    }
}
