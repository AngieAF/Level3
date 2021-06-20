import java.util.*;

public class Level1
{
    public static boolean Football(int F[], int N) {
        int[] arr = new int[F.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = F[i];

        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                arr[i] = arr[j];
                arr[j] = temp;
                if(Arranger(arr))
                    return true;
                for(int k = 0; k < arr.length; k++)
                    arr[k] = F[k];
            }
        }
        return false;

    }
    public static boolean Arranger(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }
}
