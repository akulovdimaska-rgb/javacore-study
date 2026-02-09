package Algorithms;

import java.util.Arrays;

public class A3_SelectionSort2 {

    public static void main(String[] args) {
        int[] array = new int[]{64, 25, 12, 22, 11};

        for (int step = 0; step < array.length; step++) {
//            System.out.println(arrayToString(array));
            System.out.println(Arrays.toString(array));
            int index = min(array, step);

            int tmp = array[step];
            array[step] = array[index];
            array[index] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    private static int min(int[] array, int start) {
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
//    private static String arrayToString(int[] array) {
//        StringBuilder sb = new StringBuilder();
//        for (int num : array) {
//            sb.append(num).append(" ");
//        }
//        return sb.toString().trim(); // trim() убирает лишний пробел в конце
//    }
}
