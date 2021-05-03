import java.util.*;

public class Level1
{
    public static boolean TankRush(int H1, int W1, String S1, int H2, int W2, String S2) {
        boolean flag = false, pos = false;
        int j = 0, counter = 0;
        for(int i = 0; i < S1.length(); i++) {
            if(counter == H2 * W2) break;
            if(S2.charAt(j) == ' ' && flag == true) {
                j++;
                i = i + W2;
                pos = true;
            } else {
                if(S2.charAt(j) == S1.charAt(i)) {
                    flag = true;
                    j++;
                    counter++;
                }
                else {
                    flag = false;
                    j = 0;
                    if(pos == true) {
                        i = i - W2 - 1;
                        pos = false;
                    }
                    counter = 0;
                }
            }
        }
        return flag;
    }
}
