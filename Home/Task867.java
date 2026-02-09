package Home;

import java.util.Arrays;

public class Task867 {

    public int[][] transpose(int[][] matrix) {
        isSquareMatrix(matrix);

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] transposed = new int[columns][rows];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private void isSquareMatrix (int[][] matrix){
        boolean isSquare = Arrays.stream(matrix)
                .allMatch(array -> matrix[0].length == array.length);
        if (!isSquare) {
            throw new IllegalArgumentException("Матрица не прямоугольная");
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,7}, {4,5,6,6}, {7,8,9,1}, {4,7,1,5}};
        //[[1,2,3],
        // [4,5,6],
        // [7,8,9]];

        Task867 test = new Task867();

        int[][] transposedMatrix = test.transpose(matrix);
        System.out.println(Arrays.deepToString(transposedMatrix));

        for (int[] row : transposedMatrix){
            for (int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
