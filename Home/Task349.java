package Home;

//Даны два массива целых чисел nums1 и nums2, верните массив их пересечение
//Каждый элемент в результате должен быть уникальным, и вы можете возвращать результат в любом порядке.
//Пример 1:
//Ввод: nums1 = [1,2,2,1], nums2 = [2,2]
//Вывод: [2]
//
//Пример 2:
//Входные данные: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Выходные данные: [9,4]
//Пояснение: [4,9] также подходит.
//
//Ограничения:
//
//1 <= nums1.length, nums2.length <= 1000
//0 <= nums1[i], nums2[i] <= 1000

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task349 {


    public int[] intersections(int[] nums1, int[] nums2) {
        Set<Integer> firstSet = new HashSet<>(); // создаем два Сета на базе HashSet
        Set<Integer> secondSet = new HashSet<>();

        for (int num : nums1) {                 // наполняем первый Сет значениями из массива num1
            firstSet.add(num);
        }

        for (int num : nums2) {                 // наполняем второй Сет значениями из массива num2
            secondSet.add(num);
        }
//
//        Set<Integer> intersections = new HashSet<>(); //создаем Сет для сохранения пересечений значений
//
//        if (firstSet.size() < secondSet.size()) {     //проверяем какой из Сетов имеет бо'льшее количество значений
//            for (int num : firstSet) {
//                if (nusecondSet.contains(m)) {        //если второй Сет больше, то используем выборку значений из него
//                    intersections.add(num);
//                }
//            }
//        } else {                                      //условие, если первый Сет больше второго
//            for (int num : secondSet) {
//                if (firstSet.contains(num)) {
//                    intersections.add(num);
//                }
//            }
//
//        }
        firstSet.retainAll(secondSet);           //можно выполнять в любой последовательности

        int[] result = new int[firstSet.size()]; // необходимо вернуть результирующий массив пересечений
        int indx = 0;
        for (int num : firstSet) {                   // возможно использовать только форич!
            result[indx++] = num;                // с длиной intersections
        }
        return result;

//int[] result = new int[intersections.size()]; //возвращаем массив пересечений
//        int indx = 0;
//        for (int num : intersections){
//        result[indx++] = num;
//        }
//        return result;
    }

    public static void main(String[] args) {
        Task349 is = new Task349();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};

//        int[] nums1  = new int[] {9,4,9,8,4};
//        int[] nums2 = new int[] {4,9,5};

        int[] result = is.intersections(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }
}
