package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**Нужно:
 1. Удалить дубликаты.
 2. Отсортировать по алфавиту.
 3. Преобразовать каждое слово в верхний регистр.
 4. Собрать результат в список.
 Ожидаемый результат:
 [BOOT, DOCKER, JAVA, KAFKA, SPRING]
 */
public class Task9 {
    static void main(String[] args) {
        List<String> words = Arrays.asList("java", "spring", "boot", "kafka",
                "docker", "java", "spring");
        System.out.println();
    }

    public static List<String> getList(List<String> words){

            return words.stream()
                .distinct()
                .sorted()
                .map(l->l.toUpperCase())
                .toList();

    }
}
