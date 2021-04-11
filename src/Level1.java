import java.util.*;

public class Level1
{
    public static int ConquestCampaign(int N, int M, int L, int [] battalion) {

        int cells[][] = new int[M][N];

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                cells[i][j] = 0;
        }

        int filled = 0;
        for(int i = 0; i <= battalion.length / L; i += 2) {
            if(cells[battalion[i + 1] - 1][battalion[i] - 1] == 0) {
                cells[battalion[i + 1] - 1][battalion[i] - 1] = 1;
                filled += 1;
            }
        }

        int days = 1;
        while(true) {
            if(filled < M * N) {
                days += 1;
                for(int i = 0; i < M; i++)
                    for(int j = 0; j < N; j++) {
                        if (cells[i][j] == 1) {
                            if (i != (M-1)) {
                                if (cells[i+1][j] != 1) {
                                    cells[i+1][j] = 1;
                                    filled += 1;
                                }
                            }
                            if(i != 0) {
                                if (cells[i-1][j] != 1) {
                                    cells[i-1][j] = 1;
                                    filled += 1;
                                }
                            }
                            if(j != (N-1)) {
                                if (cells[i][j + 1] != 1) {
                                    cells[i][j + 1] = 1;
                                    filled += 1;
                                }
                            }
                            if(j != 0) {
                                if (cells[i][j - 1] != 1) {
                                    cells[i][j - 1] = 1;
                                    filled += 1;
                                }
                            }
                        }
                    }
            } else break;
        }
        return days;

    }
}
