import java.util.*;

public class Level1
{
    public static int [] MadMax(int N, int [] Tele) {


        for(int j = 0; j <= N/2; j++) {
            int max = Tele[0];
            for(int i = 0; i < N - 1 - j; i++) {
                if(Tele[i] >= Tele[i + 1]) {
                    max = Tele[i];
                    Tele[i] = Tele[i + 1];
                    Tele[i + 1] = max;
                }
            }
        }

        int[] impulse = new int[N];
        int k = N - 1;
        for(int j = 0; j <= Tele.length/2; j++) {
            impulse[j] = Tele[k];
            k--;
        }

        int b = 0;
        for(int a = N/2; a < Tele.length; a++) {
            Tele[a] = impulse[b];
            b++;
        }

        return Tele;
    }
}
