import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {

        int total_square = N * M;

        int filled = 0, i = 1;
        while(filled < total_square) {
            filled += L * i;
            System.out.println(filled);
            i++;
        }
        return (i-1);
    }
}
