package Algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(searchOfTarget(sortedArray, target));

    }

    public static int searchOfTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midIndex = left + (right - left) / 2; // в таком формате избегаем потенциального переполнения

            if (nums[midIndex] == target) {
                return midIndex;

            } else if (nums[midIndex] < target) {
                left = midIndex + 1;                // добавляем + 1, чтобы повторно не проверять проверенный элемент
                                                    // и чтобы предотвратить зацикливание, т.к. при left = midIndex,
                                                    // то при left == right и nums[midIndex] != target
            } else {
                right = midIndex - 1;               // добавляем - 1, чтобы повторно не проверять проверенный элемент
            }
        }
        return -1;                                  // возвращаем -1, если такой элемент не найден
    }

} //реализация стандартного метода через лямбду
//Function<int[], Function<Integer, Integer>> binarySearch = arr -> target -> {
//    int result = Arrays.binarySearch(arr, target);
//    return result >= 0 ? result : -1;
//};