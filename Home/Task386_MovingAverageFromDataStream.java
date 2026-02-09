package Home;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task386_MovingAverageFromDataStream {
    public static void main(String[] args) {
        List<Integer> input = List.of(3, 1, 10, 3, 5, 4, 8, 7);
        int sizeWindow = 4;
        System.out.println(movingAverage(input, sizeWindow));

    }

    public static List<Double> movingAverage(List<Integer> input, int sizeWindow) {

        List<Double> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            List<Integer> window;

            if (i < sizeWindow) {
                window = input.subList(0, i + 1);
//                System.out.println(window);
            } else {
                window = input.subList(i - sizeWindow + 1, i + 1);
//                System.out.println(window);
            }

            double average = window.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);

            output.add(average);
        }


        return output;
    }

}
