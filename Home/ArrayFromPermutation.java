package Home;

import java.util.Arrays;

public class ArrayFromPermutation {
    // 1920. Build Array from Permutation
// Учитывая перестановку на основе нуля nums (с индексом 0), постройте массив одинаковой длины where ans[i] = nums[nums[i]] для каждого 0 <= i < nums.length и верните его.
//Перестановка на основе нуля nums представляет собой массив различных целых чисел от 0 до nums.length - 1 (включительно).

//Т.е. нам необходимо по очереди брать из базового массива индекс равный значению индекса
//Входные данные: nums = [0,2,1,5,3,4]
//Результат: [0,1,2,4,5,3]

public static int[] arrayFromPermutation (int [] nums){
    int[] res = new int [nums.length];          // создаем массив такой же длины как у заданного
        for (int i = 0; i < nums.length; i++) { //
            res[i] = nums[nums[i]];             //  приравниваем i-тый элемент нового массива к элементу заданного массива
              //1  = nums[2]
             //   = nums[4]                                   под индексом значения заданного массива
        }
        return res;
    }
    // первая итерация нулевой индекс равен 0 - 0
    // второй индекс равен 1 - третьему элементу
    // третий индекс равен 2
    // четвертый равен 4
    // пятый равен 5
    // шестой равен 3

public static void main(String[] args) {
    int[] nums = {0,2,1,5,3,4};
    int[] res = arrayFromPermutation(nums);
    System.out.println(Arrays.toString(res));
}

}
