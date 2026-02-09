package Home;

import java.util.Arrays;
//414. Third Maximum Number
//Учитывая целочисленный массив nums, верните третье отличное от остальных максимальное число в этом массиве.
// Если третьего максимального числа не существует, верните максимальное число.
// Ограничения
// 1 <= nums.length <= 104
// -2в31 <= nums[i] <= 231 - 1

//Пример 3:
//
//Ввод: nums = [2,2,3,1]
//Вывод: 1
//Пояснение:
// Первый отдельный максимум равен 3.
// Второй отдельный максимум равен 2 (оба значения 2 учитываются вместе, так как они имеют одинаковое значение).
// Третий отдельный максимум равен 1.


public class ThirdMax {

    public int ThirdMax(int[] nums) {

        Arrays.sort(nums);            // сразу сортируем значения в массиве для удобства проверки
        int max1 = Integer.MIN_VALUE; // присваиваем заведомо самые минимальные значения, если в массиве будет отрицательное число,
        int max2 = Integer.MIN_VALUE; //т.к. в ограничениях возможны отрицательные значения
        int max3 = Integer.MIN_VALUE;

            for (int num : nums){
                if (num > max1){ // сравниваем поочереди числа из массива
                    max3 = max2; // здесь важен порядок присваивания значений
                    max2 = max1; // иначе,если изначально присваивать по очереди max1, max2, max3,
                    max1 = num;  // то все они будут равны одному числу
                } else if (max1 > num && num > max2){
                    max3 = max2;
                    max2 = num;
                } else if (max2 > num && num > max3){
                    max3 = num;
                }
            }
                return max3 = (max3 == Long.MIN_VALUE) ? (int) max1 : (int) max3; // здесь  можно использовать тернарный оператор

        }






    public static void main(String[] args) {
        ThirdMax third = new ThirdMax();
        int[] nums = {2, 2, 3, 1};
        int result = third.ThirdMax(nums);
        System.out.println(result);

    }
 }