package Home;

import java.util.Arrays;



public class FillDmMassive {
    public static void fill(int[][] data, int value) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++)
                data[i][j] = value;

        }

        System.out.println(Arrays.deepToString(data).replace("], ", "]\n"));

    }

    public static void main(String[] args) {
        int[][] months = {{31, 28}, {31, 30, 31}, {30, 31, 31}};
        fill(months, 8);
    }
}
