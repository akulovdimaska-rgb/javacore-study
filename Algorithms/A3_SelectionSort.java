package Algorithms;

public class A3_SelectionSort {

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Находим минимальный элемент в оставшейся части массива
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Меняем найденный минимальный элемент с текущим элементом
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Исходный массив:");
        printArray(array);

        selectionSort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }

    // Вспомогательный метод для вывода массива
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}











