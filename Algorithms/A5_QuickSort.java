package Algorithms;

import java.util.Arrays;
// Быстрая сортировка. Но производительность при определенных условиях может быстро деградировать O(n2)
public class A5_QuickSort {
    public static void main(String[] args) {

        int[] array = new int[]{41, 32, 64, 32, 12, 28, 62, 55, 18, 71, 36, 49};

        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
// это рекурсивнй метод, реализующий стратегию "разделяй и властвуй"
    static void quickSort(int[] arr, int from, int to) {
// это базовое условие, гарантирует что рекурсия остановится, когда подмассив станем не более 1 элемента
        if (from < to) {
// здесь метод partition возвращает индекс, который делит массив на две части
            int divideIndex = partition(arr, from, to);
            // для просмотра промежуточной сортировки
            //printSortStep(arr, from, to, divideIndex);
// здесь метод вызывает сам себя - рекурсия. Левая и правая части сортируются отдельно
            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);

        }
    }
// цель метода partition - разделить массив на две части относительно pivot
    private static int partition(int[] arr, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        // ***Для этого метода наихудший вариант, когда массив уже отсортирован.
        // Большой размер массива может вызвать переполнение стека.
        // Чтобы этого избежать, можно выбрать опорный элемент в середине массива
        // int pivot = arr[from + (to - from) / 2];
        int pivot = arr[from];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        // если не находим второй элемент, то разделение происходит по элементу для которого не нашли пару
        return leftIndex;
    }
// метод для обмена значениями индексов, если Index2 больше index1
    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;

    }
// Этом метод показывает информацию о каждом шаге разделения массива
//    private static void printSortStep(int[] arr, int from, int to, int divideIndex) {
//        System.out.printf("Подмассив [%d-%d], разделение на диске %d: %s%n", from, to, divideIndex, Arrays.toString(arr));
//    }

}
