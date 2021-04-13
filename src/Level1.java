import java.util.*;

public class Level1
{
    public static int [] SynchronizingTables(int N, int [] ids, int [] salary) {

        int[] temp_arr = new int[N];
        for(int i = 0; i < ids.length; i++)
            temp_arr[i] = ids[i];

        sorting(temp_arr);
        sorting(salary);

        HashMap<String, String> salaryTable = new HashMap<String, String>();
        for(int i = 0; i < ids.length; i++)
            salaryTable.put(String.valueOf(temp_arr[i]), String.valueOf(salary[i]));

        for(int i = 0; i < ids.length; i++)
            salary[i] = Integer.parseInt(salaryTable.get(String.valueOf(ids[i])));

        return salary;
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
