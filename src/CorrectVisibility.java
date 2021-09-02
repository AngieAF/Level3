public class CorrectVisibility {
    /*
    for(int i = input.length() - 1; i > 0; i--) {
            sym1 = input.charAt(i - 1);
            sym2 = input.charAt(i);
            if (sym1 <= sym2) {
                dec_element = input.charAt(i - 1);
                ind = i - 1;
                //System.out.println(dec_element);
                break;
            }
        } --> findDecliningElement(input, dec_element, ind, sym1, sym2); -->
        Combined similar functionality in separate function;

        public static int[] arrayCopy(int[] F) {
        int[] arr = new int[F.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = F[i];
        return arr;
    } --> Put array copying into separate function;

    nt[] doors = new int[k];
        for(int i = 0; i < k; i++)
            doors[i] = 0; --> public static int[] doorSequenceInitilizor(int k) --> put array initialization
            into separate function;

     LinkedHashMap<Character, Integer> symbols = new LinkedHashMap();
        int num = 0;
        for(int i = 0; i < s.length(); i++)
            symbols.put(s.charAt(i), num);

        for(int i = 0; i < s.length(); i++) {
            num = symbols.get(s.charAt(i)) + 1;
            symbols.put(s.charAt(i), num);
        } --> public static LinkedHashMap<Character, Integer> hashMapConverter(String s) -->
        placed conversion to hashMap into separate function

        int total = 0;
        for(int i = 0; i < fin_arr.size(); i++)
            total += fin_arr.get(i);

        if(total % 2 == 0)
            return true;
        else return false; --> public static boolean isTotalEven(ArrayList<Integer> fin_arr) -->
        placed the check of final result of the function into separate function

         int[][] matrix = new int[H][W];
        for(int i = 0; i < tree.length; i++) {
            for(int j = 0; j < tree[i].length(); j++) {
                if(tree[i].charAt(j) == '+')
                    matrix[i][j] = 1;
                else matrix[i][j] = 0;
            }
        } --> public static int[][] matrixInitilizor(String[] tree, int H, int W) -->
        placed matrix initialization in a separate function

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
        } --> isEvenYear(year, matrix, W, H); --> placed check and actions for even year in separate function;

        if((Integer.parseInt(String.valueOf(num)) +
                Integer.parseInt(String.valueOf(village.charAt(s))) == 10)) {
            for(int i = s - 1; i > num_pos; i--) {
                if(village.charAt(i) == '=')
                    counter++;
            }
            if(counter != 3) return false;
            counter = 0; --> public static boolean whiteWalkerDetector(int num, String village, int s,
            int num_pos, int counter) --> placed functionality related to white walker detection into separate function

            public static int elementsInput(String s) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println(s);
            int N = keyboard.nextInt();
            return N;
            } --> placed user inputs into a separate function

             public static void matrixPrinter(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j]);
        }
    } --> placed matrix printing into separate function

     */
}
