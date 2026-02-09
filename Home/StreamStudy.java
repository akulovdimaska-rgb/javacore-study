package Home;

import java.util.List;

public class StreamStudy {

    static void main() {
        List<String> names = List.of("Анна", "Борис", "Виктория", "Дмитрий", "Елена");
        // Создаем стрим и выводим все элементы
        names.stream()
                .forEach(name -> System.out.println(name));
        // Фильтруем элементы с длиной больше 4-х символов
        names.stream()
                .filter(name ->name.length() > 4)
                .forEach(System.out::println);
        // Преобразуем элементы
        names.stream()
                .map(name -> name.toUpperCase()) // метод-референс (String::toUppercase());
                .forEach(x -> System.out.println(x));
              //.forEach(System.out::println()); метод референс

        names.stream()
                .filter(name -> name.startsWith("В"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(evenNumber -> evenNumber * 10)
                .forEach(System.out::println);
    }
}
