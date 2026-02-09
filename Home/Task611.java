package Home;
// 611. Valid Triangle Number
// Дан целочисленный массив nums, его значения - это длины сторон треугольника.
// Верните количество троек, выбранных из массива, которые могут образовать треугольник,

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.IntStream;

public class Task611 {

    public static void main(String[] args) {
        int[] nums = {3,  2, 4, 1, 5};
        System.out.println(findTriplets(nums));
    }

    // сложность O(n3)
    public static int findTriplets(int[] sides) {

        // Сумма длин двух сторон должна быть больше третьей, т.е. a + b > c  //  a <= b <= c

        int count = 0;
        // Можно сделать сортировку массива
        Arrays.sort(sides);
        // А затем пройтись через циклы, используя индексы
        // Поскольку массив отсортирован, можно сравнить крайний правый элемент с суммой левых
        for (int c = sides.length - 1; c >= 2; c--) {       // {1, 2, 3, 4, 5} // c = 4
            for (int a = 0; a < c - 1; a++) {               // a = 1
                for (int b = a + 1; b < c; b++) {           // b = 3
                    if (sides[a] + sides[b] > sides[c]) {   // 2 + 4 = 5
                        count++;                            // count = 1
                    }

                }

            }
        }
        return count;
    }

    public static int findTriplets2(int[] sides) {

        // Сумма длин двух сторон должна быть больше третьей, т.е. a + b > c

        int count = 0;
        int n = sides.length;
        Arrays.sort(sides);

        for (int c = n - 1; c >= 2; c--) {
            int left = 0;                       // указатель на сторону a
            int right = c - 1;                  // указатель на сторону b

            // оптимизация - сложность снизилась до O(n2)
            while (left < right) {
                if (sides[left] + sides[right] > sides[c]) { // {1, 2, 3, 4, 5};
                    count += (right - left);    // подходят все элементы в промежутке от left до right-1
                    right--;                    // смещаем правый указатель влево
                } else {
                    left++;                     // смещаем левый указатель вправо
                }
            }
        }
        return count;
    }


    public static int findTriplets3(int[] sides) {
        Arrays.sort(sides);
        return (int) IntStream.range(0, sides.length)                                        // создаем поток индексов i от 0 до конца массива
                .boxed()                                                                     // конвертируем Intstream в Stream<Integer> (нужно для FlatMap)

                // Для каждого i создаём поток j (от i+1 до конца)
                .flatMap(i -> IntStream.range(i + 1, sides.length)
                        .boxed()                                                             // конвертируем Intstream в Stream<Integer>

                        // Для каждой пары (i,j) создаём поток k (от j+1 до конца)
                        .flatMap(j -> IntStream.range(j + 1, sides.length)

                                // Преобразуем индексы (i,j,k) в массив значений
                                .mapToObj(k -> new int[]{sides[i], sides[j], sides[k]})
                        )
                )
                // Фильтруем тройки по условию треугольника (a + b > c)
                .filter(triplet -> triplet[0] + triplet[1] > triplet[2])
                .count();                                                                     // Считаем количество оставшихся троек

    }
}
