package Algorithms;

import java.util.Arrays;

public class A8_Search {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        //bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(searchLinear(array, 10));
        System.out.println(searchBinaryRecursive(array, 0, array.length - 1, 74));
    }

    public static int searchLinear(int[] array, int elementToFind){
        for (int i = 0; i < array.length; i++){
            System.out.println(i);
            if (array[i] == elementToFind) {
                System.out.println(i);
                return i;
            }
        }
        return -1;
    }

//    public static void bubbleSort (int[]array){
//        boolean isSorted = false;
//        while (!isSorted) {
//            isSorted = true;
//            for (int i = 1; i < array.length; i++) {
//                if (array[i] < array[i - 1]) {
//                    int temp = array[i];
//                    array[i] = array[i - 1];
//                    array[i - 1] = temp;
//                    isSorted = false;
//                }
//    }


    // реализация двоичного поиска с рекурсией
    public static int searchBinaryRecursive(int[] array, int startIndex, int endIndex, int elementToFind){
        if (endIndex >= startIndex){
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind){
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
            }
        }
        return -1;
    }

    // реализация двоичного поиска с рекурсией
//    public static int searchBinary(int[] array, int elementToFind){
//        int startIndex = 0;
//        int endIndex = array.length - 1;
//        int middleIndex;
//        while (startIndex <= endIndex){                             // поиск ведётся, если есть хотя бы один элемент
//            middleIndex = startIndex + (endIndex - startIndex) / 2;
//
//            if (array[middleIndex] == elementToFind){               // если средний элемент равен искомому элементу
//                return middleIndex;
//            }
//
//            if (array[middleIndex] > elementToFind) { // если средний элемент больше искомого
//                endIndex = middleIndex - 1;     // сдвигаем последний индекс на середину, без учёта среднего элемента
//            } else {
//                startIndex = middleIndex + 1;   // сдвигаем начальный индекс на середину, без учёта среднего элемента
//            }
//        }
//        return -1;
//    }


}
