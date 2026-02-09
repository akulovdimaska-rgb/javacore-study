package Algorithms;

import java.util.Arrays;
// Сортировка пузырьком. Временная сложность O(n*n), т.к. 2 цикла, зависимость каждого из которых O(n).
public class A2_BubbleSort {
    public static void main(String[] args) {

        int[] array = new int[] {14, 23, 46, 21, 82, 26, 55, 81, 17, 63, 10};

        System.out.println(Arrays.toString(array));

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}