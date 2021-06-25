import java.util.*;

public class Level1
{
    public static String Keymaker(int k) {
        int[] doors = new int[k];
        for(int i = 0; i < k; i++)
            doors[i] = 0;

        int j = 0; int step = 0;
        for(int i = 1; i <= k; i++) {
            step = i; j = i - 1;
            while(j < k) {
                if(doors[j] == 0)
                    doors[j] = 1;
                else doors[j] = 0;
                j += step;
            }
        }

        String res = "";
        for(int i = 0; i < doors.length; i++)
            res += String.valueOf(doors[i]);

        return res;
    }
}
