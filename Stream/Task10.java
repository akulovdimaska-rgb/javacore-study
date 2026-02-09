package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Дан список чисел:
 * List<Integer> numbers = Arrays.asList(5, 12, 3, 21, 8, 7, 30, 18);
 * Нужно:
 * 1. Оставить только чётные числа.
 * 2. Умножить каждое число на 2.
 * 3. Отсортировать по убыванию.
 * 4. Найти сумму всех элементов.
 * Ожидаемый результат:
 * Сумма = 120
 */
public class Task10 {
    static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 3, 21, 8, 7, 30, 18);
        System.out.println(getSum(numbers));
    }

    public static int getSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(num-> num % 2 == 0)
                .map(evenNum->evenNum*2)
                .sorted(Comparator.reverseOrder())
                .reduce(0, (a, b) -> Integer.sum(a, b));
    }

}
