package Home;
// 657. Robot Return to Origin
//Робот находится в точке (0, 0) на двумерной плоскости. Учитывая последовательность его перемещений,
// определите, окажется ли этот робот в точке (0, 0) после завершения перемещений.
//
//Вам дана строка moves, которая представляет собой последовательность перемещений робота, где moves[i] обозначает
// его ith перемещение. Допустимые перемещения: 'R' (вправо), 'L' (влево), 'U' (вверх) и 'D' (вниз).
//
//Вернитесь true если робот вернётся в исходную точку после выполнения всех своих действий, или falseв противном случае.
//
//Примечание: направление, в котором «смотрит» робот, не имеет значения.
//'R' всегда заставит робота один раз переместиться вправо, 'L' всегда заставит его переместиться влево и т. д.
// Кроме того, предположим, что величина перемещения робота одинакова для каждого перемещения.

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RobotReturnToOrigin {
    public static boolean circleMove1(String steps) {
        if (steps == null) {

            throw new IllegalArgumentException("Введен неверное значение");
        }
        int x = 0; // мы знаем, что начальные координаты робота равны нулю.
        int y = 0;

        char[] stepCharArray = steps.toCharArray(); // перевожу String в массив Чаров

        for (char step : stepCharArray) {           //
            //for (step : steps.toCharArray()){       //можно преобразование в массив чар и проход циклом сделать одной строкой

            // здесь использован улучшенный switch (с java 12): он лямбда-подобный, не нужно писать break, компактный
            // это удобный способ организовать ветвление в зависимости от значения переменной. Он часто используется
            // вместо множественных if-else, когда нужно сравнить одну переменную с несколькими возможными значениями.

            switch (step) {                          // в зависимости от символа, обновляем координаты
                case 'L' -> x--;                     // уменьшаем x на 1, если step (шаг) равен L;
                case 'R' -> x++;                     // увеличиваем x на 1, если step (шаг) равен R;
                case 'U' -> y++;                     // увеличиваем y на 1, если step (шаг) равен U;
                case 'D' -> y--;                     // уменьшаем y на 1, если step (шаг) равен D;
                default -> System.out.println("Прошу обратить внимание - неверное действие!");
            }
        }
        return x == 0 && y == 0;                     // вернёт true если робот придёт в начальную точку
    }

    //второй вариант решения с использованием HashMap чем он хорош:
    //более гибкий код - можно легко учесть и добавить новые типы движения
    //логика подсчёта становится более явной
    public static boolean circleMove2(String steps) {
        char[] stepCharArray = steps.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char step : stepCharArray) {                            // здесь мы проходим по массиву символов и заполняем Мапу
            map.put(step, map.getOrDefault(step, 0) + 1); // DeepSeek предложил использовать getOrDefault
        }                                                            //т.е. вернуть значение по ключу, а если его нет, то вернуть значение по умолчанию

        return map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0))
                && map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0));
    }                                                                  // getOrDefault позволяет не писать дополнительный код:

    // Integer count = map.get('U');
    //if (count == null) {
    //count = 0;
    //}
    public static boolean circleMove3(String steps) {           // Третий вариант с использованием Stream
        Map<Character, Long> map = steps.chars()                // Преобразуем строку в поток кодов символов (IntStream)
                .mapToObj(c -> (char) c)                     // Преобразует поток кодов в поток символов (Stream<Character>)
                .collect(Collectors.groupingBy(                 // Группирует символы и подсчитывает их количеств
                        Function.identity(),
                        Collectors.counting()
                ));

        return map.getOrDefault('L', 0L).equals(map.getOrDefault('R', 0L)) &&
                map.getOrDefault('U', 0L).equals(map.getOrDefault('D', 0L));

        //boolean result = map.entrySet().stream() // Проверка условий при помощи Stream
        //    .allMatch(entry -> {
        //        char key = entry.getKey();
        //        long value = entry.getValue();
        //        return (key == 'L' && value == map.getOrDefault('R', 0L)) ||
        //               (key == 'R' && value == map.getOrDefault('L', 0L)) ||
        //               (key == 'U' && value == map.getOrDefault('D', 0L)) ||
        //               (key == 'D' && value == map.getOrDefault('U', 0L));
        //    });

    }

    public static void main(String[] args) {
        //String steps = "LF";
        String steps = "DLRURULLDLRUUDRD";
        //String steps = null;
        //String steps = "LL";
//        Integer w1 = 120;
//        Integer w2 = 120;
//        Integer w3 = 130;
//        Integer w4 = 130;
//        System.out.println(w3 == w4);

        boolean result = circleMove2(steps);
        System.out.println(result);
    }
}
