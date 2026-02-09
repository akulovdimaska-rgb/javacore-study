package Home;

public class NumberOfGoodPairs {
    // 1512. Количество хороших пар (Number of Good Pairs)
    // Given an array of integers nums, return the number of good pairs.
    //A pair (i, j) is called good if nums[i] == nums[j] and i < j.
    // Пара (i, j) называется хорошо если nums[i] == nums[j] и i < j,

    // т.е. хорошие пары  - числа, которые имеют одинаковое значение и отличаются только индексом

    //Example 1:   Input: nums = [1,2,3,1,1,3]   Output: 4
    //Example 2:   Input: nums = [1,1,1,1]       Output: 6
    //Example 3:   Input: nums = [1,2,3]         Output: 0
    //
    //Constraints:  //1 <= nums.length <= 100  //1 <= nums[i] <= 100


    public int numberOfGoodPairs(int [] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {          // первый цикл увеличивает первый индекс - начинается с нулевого индекса
            for (int j = i + 1; j < numbers.length; j++) {  // второй цикл увеличивает второй индекс - начинается с первого индекса
                if (numbers[i] == numbers[j] && i < j) {    // сравниваем первое число со следующим в массиве по двум условиям
                    count++;                                // если оба условия true, то пара нас устраивает и счётчик увеличивается на 1
                }                                           // такое решение подходит для небольшой выборки
            }                                               // какие подходы к поиску решений для большой выборки?
        }

        return count;
    }


    public static void main(String[] args) {
        NumberOfGoodPairs gp = new NumberOfGoodPairs();
        int[] numbers = {1, 2, 3, 1, 1, 3};
        int result = gp.numberOfGoodPairs(numbers);
        System.out.print(result);                           // выводим получившееся количество пар

    }

}



