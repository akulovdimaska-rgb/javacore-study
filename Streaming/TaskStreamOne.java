package Streaming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskStreamOne {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> words = Arrays.asList("яблоко", "кот", "дом", "кот", "солнце", "дом", "чай");
        List<String> names = Arrays.asList("Анна", "борис", "Вера", "дима", "Елена");
        List<Item> items = Arrays.asList(
                new Item("Шарф", 120.0),
                new Item("Носки", 80.0),
                new Item("Шляпа", 200.0)
        );

        TaskStreamOne task = new TaskStreamOne();

        System.out.println(task.getList1(numbers));
        System.out.println(task.getList2(words));
        System.out.println(task.getName1(names));
        task.getExpensiveItem(items);
        System.out.println(task.getExpensiveInfo(items));

        Map<String, List<Item>> groups = task.groupItemsByPrice(items);

        groups.forEach((category, list) ->
                System.out.println(category + ": " + list)
        );
    }

    public List<Integer> getList1(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(m -> m * 2)
                .collect(Collectors.toList());
    }

    public List<String> getList2(List<String> words) {
//        return words.stream()
//                .filter(s -> s.length() > 3)
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());

//        return words.stream()
//                .filter(s -> s.length() > 3)
//                .map(String::toUpperCase)
//                .sorted(Comparator.comparing(String::length))
//                .collect(Collectors.toList());

        return words.stream()
                .filter(s -> s.length() > 3)
                .distinct()
                .limit(2)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<String> getName1(List<String> names) {
        return names.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == Character.toUpperCase(s.charAt(0)))
                .sorted()
                .collect(Collectors.toList());

//        return names.stream()
//                .filter(s -> s != null && s.matches("^[A-ZA-Я].*"))
//                .sorted()
//                .collect(Collectors.toList());
    }

    /**
     * для класса Product учебного проекта
     */
//    products.stream()
//            .filter(p -> p.getPrice() > 100)
//            .map(Product::getName)
//            .sorted()
//            .collect(Collectors.toList());
    public void getExpensiveItem(List<Item> items) {
        items.stream()
                .max(Comparator.comparing(Item::getPrice))
                .ifPresent(item -> System.out.println("Самый дорогой товар: " + item.getName() + " " + item.getPrice()));


/**             return items.stream()
 .max(Comparator.comparing(Item::getPrice))
 .map(Item::getName)
 .orElseThrow(() -> new RuntimeException("Товар с максимальной ценой отсутствует"));
 *   Можно так: .orElseThrow("Нет товара")*/
    }

    public String getExpensiveInfo(List<Item> items) {
        Item mostExpensive = items.stream()
                .max(Comparator.comparing(Item::getPrice))
                .orElseThrow(() -> new RuntimeException("Нет товаров!"));

        return "Expensive is: " + mostExpensive.getName() + " " + mostExpensive.getPrice();

    }

    public Map<String, List<Item>> groupItemsByPrice(List<Item> items) {
        return items.stream()
                .collect(Collectors.groupingBy(item -> {
                    double price = item.getPrice();
                    if (price < 100) {
                        return "Эконом";
                    } else if (price < 200) {
                        return "Стандарт";
                    } else {
                        return "Люкс";
                    }
                }));
    }

}
