package Home;

//724. Find Pivot Index
//Дан массив целых чисел nums. Вычислите опорный индекс этого массива.
//Опорный индекс — это индекс, при котором сумма всех чисел, строго расположенных слева от индекса, равна сумме всех чисел, строго расположенных справа от индекса.
//Если индекс находится на левом краю массива, то левая сумма равна 0, потому что слева нет элементов. Это также относится к правому краю массива.
//Верните крайний левый индекс поворота. Если такого индекса не существует, верните -1.

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindPivotIndex {
    public static void main(String[] args) {
        //int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        int result = findPivotIndex3(nums);
        System.out.println("The First PivotIndex is: " + result);
    }

    public static int findPivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {                 // это оказался самый сложный путь O(n^2)
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {                       //считаем сумму чисел слева от индекса
                leftSum += nums[j];
            }

            for (int j = i + 1; j < nums.length; j++) {         //считаем сумму чисел справа от индекса
                rightSum += nums[j];
            }
            if (leftSum == rightSum) {                          //сравниваем левый и правый рукава
                return i;
            }
        }
        return -1;                                              // если не находим, то ввыводим -1
    }

    public static int findPivotIndex2(int[] nums) {
        int totalSum = 0;                                       // сам не догадался)) решить через эту формулу
        for (int num : nums) {                                  // через Форич считаем сумму всего массива
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {                 // вычисляем сумму слева от индекса
            if (leftSum == totalSum - leftSum - nums[i]) {      // сравниваем с разницей
                return i;                                       // здесь вычитаем значение опорного индекса
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static int findPivotIndex3(int[] nums) {
        int totalSum = Arrays.stream(nums)
                .sum();                                                        // Вычисляем общую сумму всех элементов
                                                                                // здесь .sum() - терминальная операция
        return IntStream.range(0, nums.length)
                .filter(i -> {                                              // внутри Лямбда выражения производим расчёты и сравнения
                    int leftSum = Arrays.stream(nums, 0, i)
                            .sum();                                             // не понимаю!!!
                    int rightSum = totalSum - leftSum - nums[i];                //
                    return leftSum == rightSum;
                })
                .findFirst()
                .orElse(-1);                                  // выводим значение Pivot или -1

    }
}