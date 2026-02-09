package Home;
//

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Paul");
        names.add("George");
        names.add("Ringo");
        names.add("Paul");
        names.add("John");
        names.add("Paul");

        Map<String, Long> result =
                names.stream()
                        .collect(Collectors
                                .groupingBy(name -> name, Collectors.counting()
                                ));

        System.out.println(result);
    }
}
