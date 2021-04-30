import java.util.*;

public class Level1
{
    public static int Unmanned(int L, int N, int [][] track) {
        int time = 0, delta = 0;
        for(int i = 0; i < track.length; i++) {
            for(int j = 0; j < track[i].length; j += 3) {
                if(L < track[i][j]) {
                    time = L;
                    return time;
                }
                time += track[i][j] - delta;

                if(time < track[i][j + 1])
                    time += track[i][j + 1] - track[i][j];
                else {
                    if(time % (track[i][j+1] + track[i][j + 2]) < track[i][j + 1])
                        time += time % (track[i][j+1] + track[i][j + 2]);
                }

                delta = track[i][j];
            }
        }
        if(delta < L)
            time += (L - delta);

        return time;
    }
}
