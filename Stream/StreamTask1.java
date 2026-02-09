package Stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Отфильтровать и отсортировать
 * Есть список чисел. Нужно:
 * 1. Удалить дубликаты.
 * 2. Оставить только чётные.
 * 3. Отсортировать по возрастанию.
 * 4. Собрать результат в список.
 * Пример:
 * List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 2, 10, 5, 4);
 * Ожидаемый результат:
 * [2, 4, 8, 10]
 */

/**
 * 🔹 Задача 2. Работа со строками
 * Есть список строк. Нужно:
 * 1. Привести все строки к нижнему регистру.
 * 2. Отфильтровать только те, которые начинаются с буквы "a".
 * 3. Посчитать количество таких строк.
 * Пример:
 * List<String> words = Arrays.asList("Apple", "banana", "Avocado", "apricot", "Berry");
 * Ожидаемый результат:
 * 3   // "apple", "avocado", "apricot"
 */

/**
 * Задача 3. Длины слов
 * Дан список слов. Нужно:
 * 1. Исключить дубликаты.
 * 2. Получить список длин этих слов.
 * 3. Отсортировать по возрастанию.
 * List<String> words = Arrays.asList("java", "stream", "api", "lambda", "java", "code");
 * Ожидаемый результат:
 * [3, 4, 5, 6] - ошибка - не должно быть 5-ки))
 */

/**
 * Задача 4. Среднее значение
 * Дан список чисел. Найди среднее арифметическое всех чисел, которые
 * больше 10.
 * List<Integer> numbers = Arrays.asList(5, 12, 18, 7, 30, 25, 8);
 * Ожидаемый результат:
 * (12 + 18 + 30 + 25) / 4 = 21.25
 */

public class StreamTask1 {
    static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 3, 2, 10, 5, 4);
        List<String> words = Arrays.asList("Apple", "banana", "Avocado", "apricot", "Berry");
        List<String> words2 = Arrays.asList("java", "stream", "api", "lambda", "java", "code");
        List<Integer> numbers2 = Arrays.asList(5, 12, 18, 7, 30, 25, 8);
        System.out.println(getResult(numbers));
        System.out.println(getStringsWithA(words));
        System.out.println(getFreqLetters(words));
        System.out.println(getLengthOfStrings(words2));
        System.out.println(calculateDoubleEverage(numbers2));
    }

    public static List<Integer> getResult(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .filter(e -> e % 2 == 0)
                .sorted()
                .toList();
    }

    public static Map<Integer, List<String>> getStringsWithA(List<String> words) {
        List<String> list2 = words.stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.startsWith("a"))
                .toList();

        int count = list2.size();
        return Map.of(count, list2);
//        AtomicInteger sum = new AtomicInteger(0);
//
//        return words.stream()
//                .map(s ->s.toLowerCase())
//                .filter(s ->s.startsWith("a"))
//                .collect(Collectors.groupingBy(s -> {
//                    sum.incrementAndGet();
//                    return sum;
//                }, Collectors.toList()));
    }
    //List<String> words = Arrays.asList("Apple", "banana", "Avocado", "apricot", "Berry");

    public static Map<Character, Long> getFreqLetters(List<String> words) {

        return words.stream()
                .map(s -> s.toLowerCase())
                .flatMapToInt(s -> s.chars())
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

    }

    public static List<Integer> getLengthOfStrings(List<String> words2) {

        return words2.stream()
                .map(s ->s.length())
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }

    public static double calculateDoubleEverage(List<Integer>numbers2){
        /** 1. Фильтруем числа, которые больше 10
         *
        */
        return numbers2.stream()
                .filter(i -> i > 10)
                .collect(Collectors.averagingInt(e ->e));
    }

}
