import java.util.*;

public class Level1
{
    public static int odometer(int [] oksana)
    {
        int[] speed = new int[oksana.length / 2];
        int[] time = new int[oksana.length / 2];

        int m = 0, n = 0;
        for(int i = 0; i < oksana.length; i++) {
            if(i % 2 == 0) {
                speed[m] = oksana[i];
                m++;
            }
            else {
                time[n] = oksana[i];
                n++;
            }
        }

        for(int k = time.length - 1; k > 0; k--)
            time[k] -= time[k-1];

        int total = 0;
        for(int j = 0; j < speed.length; j++)
            total += speed[j] * time[j];

        return total;

    }
}
