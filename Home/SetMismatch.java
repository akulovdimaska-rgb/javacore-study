package Home;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
// 645. Set Mismatch
//У вас есть набор целых чисел s, который изначально содержит все числа от 1 до n. К сожалению, из-за какой-то ошибки
//одно из чисел в s было продублировано другим числом из набора, что привело к повторению одного числа и потере другого числа.
//Вам дан целочисленный массив nums с данными о состоянии этого набора после ошибки.
//Найдите число, которое встречается дважды, и число, которого нет, и верните их в виде массива.

public class SetMismatch {

    public int[] SetMismatch(int[] nums) {
        int[] result = new int[2];          // т.к. необходимо вывести только 2 значения, создаем массив из 2-х элементов
        Set<Integer> seen = new HashSet<>();// создаем Set для хранения значений - повторяющиеся элементы перезапишутся
        int n = nums.length;                // создаем переменную, для вычисления суммы натуральных чисел (равна длине массива)
        int expectedSum = n * (n + 1) / 2;  // вычисляем сумму натуральных чисел по формуле арифметической прогрессии
        int actualSum = 0;                  // объявляем переменную для хранения текущей суммы чисел массива
                                            // и присваиваем начальное значение 0
        for (int num : nums) {              // проходим форичем по массиву и проверяем
            if (seen.contains(num)) {       // содержится ли в Сете. И если true, то
                result[0] = num;            // вносим присваиваем его в первому элементу результирующего массива
            } else {
                seen.add(num);              //иначе, вносим его в Set
                actualSum += num;           //и прибавляем его к текущей сумме чисел
            }
        }
        result[1] = expectedSum - actualSum; // разница между суммой натуральных чисел и суммой чисел в массиве
                                             // будет равна недостающему числу
        return result;
    }

    public int[] SetMismatch2(int[] nums) {         // если не знать этой формулы, можно использовать другой путь

        Set<Integer> isAvailable = new HashSet<>(); // создаем пустой Set
        int[] result = new int[2];                  // объявляем результирующий массив

        for (int num : nums) {                      // Во-первых, проверяем и добавляем значения в Set
            if (!isAvailable.contains(num)) {       // если число не содержится в Сете,
                isAvailable.add(num);               // добавляем его
            } else {
                result[0] = num;                    // записываем его
            }
        }
                                                    // Во-вторых, когда значения добавлены в Set
        for (int i = 0; i < nums.length; i++) {     // делаем проверку на отсутствующее число
            if (!isAvailable.contains(i)) {         // если его нет в Set
                result[1] = i;                      // записываем его во второй элемент результирующего массива
            }
        }
        return result;                              // выводим итоговый результат
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        SetMismatch sm = new SetMismatch();
        int[] result = sm.SetMismatch2(nums);
        System.out.println(Arrays.toString(result));


    }
}
