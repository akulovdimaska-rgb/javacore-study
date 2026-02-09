package Home;

import java.util.Arrays;
import java.util.List;

public class TrainStream {
    static void main() {
        List<String> names = Arrays.asList("Анна", "Борис", "Дмитрий", "Сергей", "Галина");

        names.stream()
                .filter(name -> name.startsWith("Б"))
                .forEach(name -> System.out.println(name));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Ght
        numbers.stream()
                .map(n -> n * n)
                .forEach(System.out::println);


    }
}
