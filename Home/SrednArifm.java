package Home;

import java.util.Arrays;

/**
 * Задача:
 * Дан массив целых чисел. Найдите среднее арифметическое всех его элементов, исключая минимальный и максимальный элементы (по одному экземпляру каждого, даже если они повторяются).
 * Пример:
 * Для массива int[] numbers = {3, 5, 7, 2, 8}:
 * Минимум: 2, максимум: 8.
 * Сумма остальных элементов: 3 + 5 + 7 = 15.
 * Количество оставшихся элементов: 3.
 * Среднее: 15 / 3 = 5.
 */

// Отсортировать массив или найти
// удалить первый и последний элементы
//

public class SrednArifm {

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8};
        System.out.println();
        SrednArifm srednArifm = new SrednArifm();
        System.out.println(srednArifm.arithmeticMean(numbers));
        System.out.println(srednArifm.arithmeticMeanStream(numbers));
    }

    public double arithmeticMean(int[] numbers) {
        Arrays.sort(numbers);
        int sum = 0;

        for (int i = 1; i <= numbers.length - 2; i++) {
            sum = sum + numbers[i];
        }

        double arithMean = sum * 1.0 / (numbers.length - 2);

        return arithMean;
    }

    public double arithmeticMeanStream(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .skip(1)
                .limit(numbers.length-2)
                .average()
                .orElse(0);
    }
}
