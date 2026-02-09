package Algorithms;

import java.util.Arrays;

// Сортировка слиянием. Работает медленнее, но стабильнее быстрой сортировки
// Быстрая сортировка работает со всем массивом сразу, а сортировка слиянием, может работать с частями массивов,
// т.е., можно заниматься сортировкой по мере поступления данных, она хорошо распараллеливается и сочетается с
// другими алгоритмами сортировки.
public class A6_MergeSort {
    public static void main(String[] args) {

        int[] array = new int[]{41, 32, 64, 32, 12, 28, 62, 55, 18, 71, 36, 49};

        mergeSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static int[] mergeSort(int[] array) {
        int[] tmp; // tmp - переменная-ссылка, для того чтобы менять местами массивы
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size); // вызываем процедуру слияния
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
            System.out.println(Arrays.toString(currentSrc));
            ;
        }
        return currentSrc;
    }


    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

}