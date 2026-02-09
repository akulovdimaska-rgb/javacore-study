package Home;

import java.util.Arrays;

/**
 * 1. Передаём из main массив
 * 2. Проходим по массиву, используя два индекса, для сравнения соседних элементов
 * 3. Если next элемент меньше current элемента, меняем местами, используя temp переменную
 * 4. Дошли до конца массива, последним стал самый большой элемент
 * 5. Следующий проход до next-1
 * 6. После каждого прохода сравниваем индексы:
 * если index[current] = index[next], тогда return.
 * <p>
 * {8,2,5,6,3,4,1} current
 * |2,5,6,3,4,8|
 * |2,5,3,4,6,8|
 * |1,2,3 ||  4,5,6,8|
 *
 */
public class BubbleClass {

    public int binarySearch(int[] unsorted, int target) {
        int left = 0;
        int right = unsorted.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == unsorted[mid]) {
                return mid;
            } else if (target < unsorted[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public void bubblesort(int[] unsorted) {
        int count = 0;
        while (count < unsorted.length - 1) {
            for (int i = 0; i < unsorted.length - 1 - count; i++) {
                int temp = 0;
                if (unsorted[i] > unsorted[i + 1]) {
                    temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                }
            }
            count++;
        }
        System.out.println(Arrays.toString(unsorted));
    }

    static void main(String[] args) {
        BubbleClass bs = new BubbleClass();
        int[] unsorted = {1, 8, 2, 5, 6, 3, 4};
        bs.bubblesort(unsorted);
        System.out.println(bs.binarySearch(unsorted, 10));
    }
}
