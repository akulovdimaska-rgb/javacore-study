package Home;

//728. Self Dividing Numbers
//Самоделимое число — это число, которое делится на каждую свою цифру.
//Например, 128 является числом, которое делится само на себя, потому что 128 % 1 == 0, 128 % 2 == 0, и 128 % 8 == 0.
//Самоделимое число не может содержать цифру ноль.
//Учитывая два целых числа left и right, верните список всех чисел, делящихся нацело в диапазоне [left, right] (оба включительно).

// 1) необходимо перебрать числа в диапазоне от 1 до 22;
// 2) - проверить, содержит ли число 0, если содержит, то пропустить;
//    - проверить, делится ли число на каждую свою цифру;
// 3) если условия соблюдены, добавить число в результат - result;
// 4) вернуть результат.


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class SelfDividingNumbers {

    public static void main(String[] args) {
        int left = 1;
        int right = 22;
        List<Integer> result = getSelfDividingNumbers(left, right);
        System.out.println(result);
    }

    public static List<Integer> getSelfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        if (left > right) {                                  //добавлена проверка на валидность диапазона
            throw new IllegalArgumentException("left не может быть больше right");
        }

        for (int i = left; i <= right; i++) {
                                                  // здесь провожу перебор чисел из заданного диапазона
            if (i/10 == 0 || isSelfDividing(i)) { // вызываю метод, который для проверки, является ли число самоделящимся
                result.add(i);                    // если условия выполнятся, то результат добавляем в List
            }
        }
        return result;                          // после выполнения всех итераций возвращаем результат
    }

    // создаю метод, который будет отвечать на вопрос является ли число самоделящимся
    public static boolean isSelfDividing(int number) {
        int temp = number;                      // чтобы не потерять наше число, создаем временную переменную, которую будем разбирать по частям
        while (temp > 0) {
            int digit = temp % 10;              // 150
            //проверим два условия: 1) цифра не 0 и 2) число делится на цифру
            if (digit == 0 || number % digit != 0) {
                return false;
            }
            temp = temp / 10;                   // можно писать так temp /=10 - синтаксический сахар))
        }
        return true;
    }

    // Метод через Stream
    public static List<Integer> selfDividingStream(int left, int right) {
        return IntStream.rangeClosed(left, right)       //создает поток чисел от left до right. Closed - включительно
                .filter(SelfDividingNumbers::isSelfDividing)    // через фильтр оставляем только числа, которые прошли проверку
                .boxed()                                        // преобразовали поток в поток чисел Integer
                .collect(Collectors.toList());                  // если Java <16, то .collect(Collectors.toList())
//              .toList();                                    // можно собрать элементы в список т.о. (начиная с Java 16+)
    }

}



