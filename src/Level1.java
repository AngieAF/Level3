import java.util.*;

public class Level1
{
    public static boolean TransformTransform(int A[], int N) {

        ArrayList<Integer> list = new ArrayList<>();
        for(int el:A)
            list.add(el);

        ArrayList<Integer> list_B = new ArrayList<>();
        list_B = S(list);

        ArrayList<Integer> fin_arr = new ArrayList<>();
        fin_arr = S(list_B);

        int total = 0;
        for(int i = 0; i < fin_arr.size(); i++)
            total += fin_arr.get(i);

        if(total % 2 == 0)
            return true;
        else return false;
    }

    public static ArrayList<Integer> S(ArrayList<Integer> A) {
        int k = 0;
        ArrayList<Integer> B = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.size() - i; j++) {
                k = i + j;
                int max = A.get(j);
                for(int s = j; s <= k; s++) {
                    if(A.get(s) > max)
                        max = A.get(s);
                }
                B.add(max);
            }
        }
        return B;
    }
}
