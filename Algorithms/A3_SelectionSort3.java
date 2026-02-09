package Algorithms;

import java.util.Arrays;

public class A3_SelectionSort3 {
    public static void main(String[] args) {
        int[] array = {18, 31, 3, 10, 5, 27, 7, 42};

        for (int step = 0; step < array.length; step++) {
            System.out.println(Arrays.toString(array));
            int index = minim(array, step);

            int tmp = array[step];
            array[step] = array[index];
            array[index] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int minim(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
