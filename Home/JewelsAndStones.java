package Home;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 771.Jewels and Stones
public class JewelsAndStones {
    public static void main(String[] args) {
        String stones = "aAAbbbb";
        String jewels = "aA";
        System.out.println("Количество драгоценных камней - " + HowManyStonesIsJevelse2(stones, jewels));
    }
// Т.к. у нас разные драгоценности, создаем множество драгоценностей Set, преобразуем String в Char и добавляем в Set
// Используем Set, т.к. он автоматически игнорирует дубликаты, если вдруг они будут
// затем сравниваем вид драгоценностей с minerals и если находим совпадение - увеличиваем счётчик на 1
// После завершения возвращаем count

    public static int HowManyStonesIsJevelse(String stones, String jewels) {

        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {           // Можем использовать Foreach для внесения Char в Set
            jewelSet.add(c);
        }

        int count = 0;                                  // сразу объявляем и инициализируем count

        // Чтобы была возможность сравнивать, необходимо преобразовать minerals в char - и их не надо сохранять
        // достаточно проверять и увеличивать счётчик при совпадении
        // здесь также можно использовать ForEach
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }
        return count;

    }
    // Через Stream:
    // 1. Преобразовать String jewels в множество символов (Set<Character> - !в первую очередь! - для быстрой проверки наличия символов в потоке minerals)
    // 2. Преобразовать String stones в множество символов
    // 3. Отфильтровать поток, оставив только символы, которые присутствуют в jewels
    // 4. Посчитать количество оставшихся элементов в потоке.

    public static int HowManyStonesIsJevelse2(String stones, String jewels) {
        // Здесь два основных блока:

        // 1. Преобразование String jewels в поток:
        Set<Character> jewelSet = jewels.chars()             // Здесь идёт поток IntStream (поток кодовых точек Unicode)
                .mapToObj(c -> (char) c)                  // Явно преобразуем поток int в поток Character (int → Character)
                .collect(Collectors.toSet());                // здесь при сборке автоматически удалятся дубликаты

        // 2, 3, 4 - Преобразование String stones в поток, фильтрация и подсчёт:
        return (int) stones.chars()                          // IntStream: [97, 65, 65, 98, ...]
                .mapToObj(c -> (char) c)                  // Stream<Character>: ['a', 'A', 'A', 'b', ...]
                .filter(c -> jewelSet.contains(c))  // Оставляем только символы из jewelSet
                // .filter(jewelSet::contains)               // метод референс - краткая форма для простых случаев
                .count();                                    // count - это терминальный метод - завершающий


//в лямбда можно встроить дополнительную логику:
//                .filter(c -> {
//                    boolean isJewel = jewelSet.contains(c);
//                    if (isJewel) {
//                        System.out.println("Камень " + c + " является драгоценным");
//                    }
//                    return isJewel;
//                })
//                .count();

    }
// Эффективность:
// Сложность O(n + m), где n — длина jewels, m — длина stones.
// HashSet обеспечивает проверку contains() за O(1).
// Регистрозависимость - например, символы 'a' и 'A' считаются разными, т.к. их Unicode-коды отличаются
}
