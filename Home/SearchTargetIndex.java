package Home;

/**
 * Используя бинарный поиск, найди в отсортированном массиве место для числа и верни его позицию
 * Input int[] sortedArray = {1, 3, 4, 6, 8, 9}
 * int target = 5;
 * int target = 4;
 * int target = 10;
 * int target = 0;
 */

public class SearchTargetIndex {
    static void main(String[] args) {
        int[] sortedArray = {1, 3, 4, 6, 8, 9};
        int target = 5;
        System.out.println(getTargetIndex(sortedArray, target));
    }

    static int getTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midIndex = left + (right - left) / 2; // избегаем потенциального переполнения
            if (nums[midIndex] == target) {           // при нахождении точного совпадения
                return midIndex;
            } else if (nums[midIndex] < target) {
                left = midIndex + 1;                    // ищем в правой половине
            } else {
                right = midIndex - 1;                   // ищем в левой половине
            }
        }
        return left;                                    // если не найдено, то вставляем в левой половине
    }
}
