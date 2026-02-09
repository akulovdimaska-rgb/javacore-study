package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test4 {
    static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream()
                .reduce((accumulator, element) -> accumulator*element)
                .get();
            // Если у аккумулятора уже есть значение, метод get() нет необходимости использовать
        int result2 = list.stream()
                .reduce(1, (accumulator, element) -> accumulator*element);

        // Если нет значения get() может выбросить исключение NoSuchElementException
        //List<Integer> list100 = new ArrayList<>();
//        Optional<Integer> o = list.stream()
//                .reduce((accumulator, element) -> accumulator*element)
//                .get();
        // Безопаснее использовать Optional, например orElse()

        // расширенный вариант
//        if (o.isPresent()) {
//            System.out.println(o.get());
//        }
//        else {
//            System.out.println("Not present");
//        }

        List<String> list3 = new ArrayList<>();
        list3.add("pr");
        list3.add("kd");
        list3.add("ok");
        list3.add("pk");
        String result3 = list3.stream().reduce((a,e)->a + " " + e).get();
        System.out.println(result3);

    }
}
