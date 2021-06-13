import java.util.*;

public class Level1
{
    public static void MatrixTurn(String Matrix[], int M, int N, int T) {

        int[][] matrix = new int[M][N];

        for(int i = 0; i < Matrix.length; i++)
            for(int j = 0; j < Matrix[i].length(); j++)
                matrix[i][j] = Integer.parseInt(String.valueOf(Matrix[i].charAt(j)));

        int numberOfLayers = Math.min(M, N) / 2;

        ArrayList<ArrayList<Integer>> layers = new ArrayList<>();

        for(int layer = 0; layer < numberOfLayers; layer++) {
            ArrayList<Integer> layer_matrix = new ArrayList<>();
            layerFormer(layer_matrix, matrix, layer);
            layers.add(layer_matrix);
        }

        matrixCleaner(matrix);

        ArrayList<ArrayList<Integer>> rotatedLayers = new ArrayList<>();

        int offset = 0;
        if(T < layers.get(0).size()) offset = T;
        else offset = layers.get(0).size() % T;


        for(int layer = 0; layer < layers.size(); layer++) {
            ArrayList<Integer> el = new ArrayList<>();
            for(int s = layers.get(layer).size() - offset; s < layers.get(layer).size(); s++) {
                el.add(layers.get(layer).get(s));
            }
            for(int s = 0; s < layers.get(layer).size() - offset; s++) {
                el.add(layers.get(layer).get(s));
            }
            rotatedLayers.add(el);
        }

        for(int layer = 0; layer < numberOfLayers; layer++) {
            matrixPutter(layer, rotatedLayers, matrix);
        }

        for(int i = 0; i < Matrix.length; i++)
            Matrix[i] = "";

        for(int i = 0; i < Matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++)
                Matrix[i] += matrix[i][j];
        }

    }


    public static void matrixPutter(int layer, ArrayList<ArrayList<Integer>> layers, int[][] matrix) {
        // top left to right
        int k = 0;
        for(int j = layer; j < matrix[0].length - layer; j++) {
            matrix[layer][j] = layers.get(layer).get(k);
            k++;
        }


        // right top to bottom
        for(int i = layer + 1; i < matrix.length - layer; i++) {
            matrix[i][matrix[0].length - 1 - layer] = layers.get(layer).get(k);
            k++;
        }

        // bottom right to left
        for(int j = matrix.length - layer; j > layer; j--) {
            matrix[matrix.length - 1 - layer][j] = layers.get(layer).get(k);
            k++;
        }

        // left bottom to top
        for(int i = matrix.length - 1 - layer; i >= layer + 1; i--) {
            matrix[i][layer] = layers.get(layer).get(k);
            k++;
        }
    }

    public static void layerFormer(ArrayList<Integer> layer_matrix, int[][] matrix, int layer) {
        //layer_matrix.add(matrix[layer + 1][layer]);

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

    public static void matrixCleaner(int[][] matrix) {
        // Initialize matrix with zeros
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = 0;
    }

}
