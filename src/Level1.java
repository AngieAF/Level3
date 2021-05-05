import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        boolean flag = false;
        int j = 0, counter = 0, old_pos = 0;
        for (int i = 0; i < S1.length(); i++) {
            if(counter == (S2.length() - 1)) break;

            if (S2.charAt(j) == ' ' && flag == true) {
                i = i + (W1 - W2 + 1);
                j++;
            }
            if (S2.charAt(j) == S1.charAt(i)) {
                j++;
                flag = true;
                counter++;
                if(counter % W2 == 0)
                    old_pos = i;
            } else {
                if(flag == true)
                    i = old_pos;
                flag = false;
                old_pos = 0;
                j = 0;
                counter = 0;
            }
        }
        return flag;
    }
}
