import java.util.*;

public class Level1
{
    public static String MassVote(int N, int[] Votes) {
        String res = "";
        int[] arr_copy = new int[Votes.length];

        for(int i = 0; i < arr_copy.length; i++)
            arr_copy[i] = Votes[i];

        sorting(arr_copy);

        int counter = 0, element = -1;
        for(int i = 0; i < Votes.length; i++) {
            if (Votes[i] == arr_copy[arr_copy.length - 1]) {
                counter++;
                element = i + 1;
            }
        }

        int sum = 0;
        for(int i = 0; i < Votes.length; i++)
            sum += Votes[i];

        int percentage = 0;

        percentage = arr_copy[arr_copy.length - 1] * 100 / sum;

        if(counter > 1) {
            res = "no winner";
        } else {
            if(percentage > 50)
                res = "majority winner " + element;
            else res = "minority winner " + element;
        }

        return res;
    }

    public static int[] sorting(int[] arr) {
        for(int j = 0; j <= arr.length/2 + 1; j++) {
            int max = arr[0];
            for(int i = 0; i < arr.length - 1 - j; i++) {
                if(arr[i] >= arr[i + 1]) {
                    max = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = max;
                }
            }
        }
        return arr;
    }
}
