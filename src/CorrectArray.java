import java.util.ArrayList;

public class CorrectArray {
    public static String Keymaker(int k) {


        ArrayList<Integer> doors = new ArrayList<>(k);
        for(int i = 0; i < k; i++)
            doors.add(0);
        System.out.println(doors);
        //int[] doors = doorSequenceInitilizor(k);
        int j = 0;
        int step = 0;
        /*for (int i = 1; i <= k; i++) {
            step = i;
            j = i - 1;
            while (j < k) {
                if (doors[j] == 0)
                    doors[j] = 1;
                else doors[j] = 0;
                j += step;
            }
        }*/
        for(int i = 1; i <= k; i++) {
            step = i; j = i - 1;
            while(j < k) {
                if(doors.get(j) == 0)
                    doors.set(j, 1);
                else doors.set(j, 0);
                j += step;
            }
        }

        String res = "";
        /*for (int i = 0; i < doors.length; i++)
            res += String.valueOf(doors[i]);*/
        for(int i = 0; i < doors.size(); i++)
            res += String.valueOf(doors.get(i));

        return res;
    } --> Заменила массив на ArrayList;

    public class Football {
        public static void main(String[] args) {
            int[] arr = {1, 4, 3, 2, 5};
            System.out.println(Football(arr, 3));
        }

        public static boolean Football(int F[], int N) {
            ArrayList<Integer> arr = arrayCopy(F);

            int temp = 0;
            for(int i = 0; i < arr.size(); i++) {
                temp = arr.get(i);
                for(int j = i + 1; j < arr.size(); j++) {
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                    if(Arranger(arr))
                        return true;
                    for(int k = 0; k < arr.size(); k++)
                        arr.set(k, F[k]);
                }
            }
            return false;

        }
        public static ArrayList<Integer> arrayCopy(int[] F) {
        /*int[] arr = new int[F.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = F[i];
        return arr;*/

            ArrayList<Integer> arr = new ArrayList<>(F.length);
            for(int i = 0; i < arr.size(); i++)
                arr.add(F[i]);
            return arr;
        }

        public static boolean Arranger(ArrayList<Integer> arr) {
            for(int i = 0; i < arr.size() - 1; i++) {
                if(arr.get(i) > arr.get(i + 1))
                    return false;
            }
            return true;
        }
    } --> Заменила массив на ArrayList;

    public class MaxClass {
        public static void main(String[] args) {
            //int [] a1 = new int[10];

            ArrayList<Integer> a1 = new ArrayList<>(10);


            for(int i = 0; i < 10; i++)
                a1.set(i, 10 - i);

            int max = 0;
            for(int i = 0; i < 10; i++) {
                if(max < a1.get(i)) max = a1.get(i);
            }

            for(int i = 0; i < 10; i++) {
                if(a1.get(i) == max) {
                    a1.set(i, 0);
                    break;
                }
            }

            max = 0;
            for(int i = 0; i < 10; i++) {
                if(max < a1.get(i)) max = a1.get(i);
            }
            System.out.println(max);
        }
    } --> Заменила массив на ArrayList;

    public class Reversed {
        public static void main(String[] args) {
            int N = 5;
            //int[] a1 = new int[N];
            Random rand = new Random();
            ArrayList<Integer> a1 = new ArrayList<>(N);

            for(int i = 0; i < N; i++)
                a1.set(i, rand.nextInt(50) + 1);

            int k = 0;
            for(int i = N - 1; i >= 0; i--) {
                a1.set(k, a1.get(i));
                k++;
            }

            System.out.println(a1);


        }
    } --> Заменила массив на ArrayList;

}
