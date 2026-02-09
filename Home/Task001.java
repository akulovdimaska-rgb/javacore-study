package Home;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task001 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("яблоко", "кот", "банан", "дом", "электричество");
        Task001 task001 = new Task001();

        System.out.println(task001.getList(words));
        System.out.println(task001.getLengthOfWords(words));
        System.out.println(task001.getSortedListByLength(words));
    }

    public List<String> getList(List<String> words) {
        return words.stream()
                .filter(w -> w.length() < 6)
                .collect(Collectors.toList());
    }

    public List<Integer> getLengthOfWords(List<String> words) {
        return words.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public List<String> getSortedListByLength(List<String> words) {
        return words.stream()
                .distinct()
                .sorted(Comparator.comparing(s -> s.length()))
                .collect(Collectors.toList());
    }

//        return words.stream()
//                .distinct()
//                .sorted(
//                        Comparator.comparing(w -> w.length()) // с лямбдой ошибка, т.к.
//                                .thenComparing(String::compareTo)
//                )
//                .collect(Collectors.toList());

    // если сортировать ещё и по алфавиту
//        public List<String> getSortedListByLength(List<String> words) {
//            return words.stream()
//                    .distinct()
//                    .sorted(Comparator.comparing((String w) -> w.length())
//                            .thenComparing((String w) -> w))
//                    .collect(Collectors.toList());


}
