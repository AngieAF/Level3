public class CleanCodeComments {
    int year = 1;
// Models N years of tree development
while(year <= N){
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += 1;
            }
        }

        for(int i = 0; i < count_arr.size(); i++) {
            if(count_arr.get(i) != counter) {
                if(temp_counter == 0) {
                    temp = count_arr.get(i) - 1;
                    temp_counter++;
                    // all symbols were met the same number of times
                    if (temp != counter && temp != 0)
                        flag = false;
                } else flag = false;
            }
        }

        public static void layerFormer(ArrayList<Integer> layer_matrix, int[][] matrix, int layer) {

            // top left to right
            for(int j = layer; j < matrix[0].length - layer; j++) {
                layer_matrix.add(matrix[layer][j]);
            }
            System.out.println(layer_matrix);

            // right top to bottom
            for(int i = layer + 1; i < matrix.length - layer; i++) {
                layer_matrix.add(matrix[i][matrix[0].length - 1 - layer]);
            }
            System.out.println(layer_matrix);

            // bottom right to left
            for(int j = matrix.length - layer; j > layer; j--)
                layer_matrix.add(matrix[matrix.length - 1 - layer][j]);
            System.out.println(layer_matrix);

            // left bottom to top
            for(int i = matrix.length - 1 - layer; i >= layer + 1; i--)
                layer_matrix.add(matrix[i][layer]);
            System.out.println(layer_matrix);

        }

        for(int j = ind; j < input.length() - 1; j++) {
            // if the word is lexicographically smallest
            if((input.charAt(j + 1) - dec_element) <= dif && (input.charAt(j + 1) - dec_element) > 0) {
                dif = input.charAt(j + 1) - dec_element;
                swap_ind = j + 1;
            }
        }

    }
