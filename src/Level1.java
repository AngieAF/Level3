import java.util.*;

public class Level1
{
    public static String[] TreeOfLife(int H, int W, int N, String [] tree) {
        int[][] matrix = new int[3][4];
        for(int i = 0; i < tree.length; i++) {
            for(int j = 0; j < tree[i].length(); j++) {
                if(tree[i].charAt(j) == '+')
                    matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
        }

        int year = 1;
        while(year <= N){
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += 1;
                }
            }

            if(year % 2 == 0) {
                for(int i = 0; i < matrix.length; i++) {
                    for(int j = 0; j < matrix[i].length; j++) {
                        if(matrix[i][j] >= 3) {
                            matrix[i][j] = 0;
                            if(j > 0 && matrix[i][j - 1] < 3) matrix[i][j - 1] = 0;
                            if(j < W - 1 && matrix[i][j + 1] < 3) matrix[i][j + 1] = 0;
                            if(i > 0 && matrix[i - 1][j] < 3) matrix[i - 1][j] = 0;
                            if(i < H - 1 && matrix[i + 1][j] < 3) matrix[i + 1][j] = 0;
                        }
                    }
                }
            }
            year++;
        }

        String[] fin_arr = new String[matrix[0].length];
        for(int i = 0; i < fin_arr.length; i++)
            fin_arr[i] = "";

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0)
                    fin_arr[i] += '.';
                else fin_arr[i] += '+';
            }
        }

        return fin_arr;
    }

}
