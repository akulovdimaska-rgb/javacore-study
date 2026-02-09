package Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 498. Диагональный обход
// Для матрицы m x n mat верните массив всех элементов массива в диагональном порядке.
public class Task498_Diagonal_Traverse {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(getDiagonalOrder(mat)));
    }

    public static int[] getDiagonalOrder(int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Матрица матрица не может быть null");
        }
        if (mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Матрица пуста или некорректна");
        }

//        List<Integer> resultOrder = new ArrayList<>();
        int rows = mat.length;
        int columns = mat[0].length;
        int[] resultOrder = new int[rows * columns];
        int index = 0;

        for (int k = 0; k < rows + columns - 1; k++) {

            if (k % 2 == 0) {
                int i = Math.min(k, rows - 1); // Math.min - это гарантия того, что мы не выйдем за пределы строки
                int j = k - i;
                // Если диагональ чётная, то двигаемся вверх и вправо
                while (i >= 0 && j < columns) {
//                    resultOrder.add(mat[i][j]);
                    resultOrder[index++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {
                int j = Math.min(k, columns - 1);
                int i = k - j;
                // Если диагональ нечётная, то двигаемся вниз и влево
                while (i < rows && j >= 0) {
//                    resultOrder.add(mat[i][j]);
                    resultOrder[index++] = mat[i][j];
                    i++;
                    j--;
                }
            }
        }

//        int[] resulted = new int[resultOrder.size()];
//        for (int i = 0; i < resulted.length; i++) {
//            resulted[i] = resultOrder.get(i);
        return resultOrder;
    }
}

