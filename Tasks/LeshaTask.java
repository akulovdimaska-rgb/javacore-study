package Tasks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*Нужно развернуть мапу с помощью стрима
inputMap: 1 =[0, 1, 2], 2 = [3, 4]
outputMap: 0=1, 1=1, 2=1, 3=2, 4=2**/
public class LeshaTask {

    static void main(String[] args) {
        Map<Integer, List<Long>> map = Map.of(1, List.of(0L, 1L, 2L), 2, Arrays.asList(3L, 4L));

        System.out.println(reverseMap(map));
    }

    private static Map<Long, Integer> reverseMap(Map<Integer, List<Long>> map) {
        return map.entrySet()
                .stream()
                .flatMap(entry -> {
                    Integer k = entry.getKey();
                    List<Long> v = entry.getValue();
                    return v.stream()
                            .map(e -> Map.entry(e, k));
                })
                .collect(Collectors.toMap(key -> key.getKey(), val -> val.getValue()));
                                                //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
