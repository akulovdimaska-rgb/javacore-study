package Home;
import java.util.*;

//Учитывая массив nums из n целых чисел, где nums[i] находится в диапазоне [1, n],
//верните массив всех целых чисел в диапазоне, [1, n] которые не встречаются в nums.
//Пример 1:
//Ввод: nums = [4,3,2,7,8,2,3,1]
//Вывод: [5,6]

//Пример 2:
//Ввод: nums = [1,1]
//Вывод: [2]
//Ограничения: n == nums.length
//1 <= n <= 10^5; 1 <= nums[i] <= n

public class DisappearedNumbers {

    public List<Integer> disNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();         // создаю Сет, т.к. нам нужны только ключи
        for (int n : nums) {                         // с помощью цикла
            set.add(n);                             //заполняю значениями Сет
        }

        List<Integer> ans = new ArrayList<>();      // создаем список

        for (int i = 1; i <= nums.length; i++) {    // Начинаем с 1, т.к. числа начинаются с 1 по условию задачи
            if (!set.contains(i)) {
                ans.add(i);                         // проверяем отсутствующие значения и
            }                                       // вносим не найденные значения в Список
        }
        return ans;
    }

    public static void main(String[] args) {
        DisappearedNumbers dn = new DisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Integer[] result = dn.disNumber(nums).toArray(new Integer[0]);
        System.out.println(Arrays.toString(result));
    }
}
