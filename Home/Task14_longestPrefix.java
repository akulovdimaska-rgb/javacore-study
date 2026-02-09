package Home;

import java.util.Arrays;

//Longest Common Prefix
//Напишите функцию для поиска самого длинного общего префикса в массиве строк.
//Если общего префикса нет, верните пустую строку "".
public class Task14_longestPrefix {

    public static void main() {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }
    // Проверяю, что массив не null и не пустой.
    // Сортирую лексикографически массив strings.
    // Сравниваю первый и последний элемент массива. Вытаскиваю тот, который min длины - это будет наибольшее количество совпадений.
    // Сравниваю посимвольно Char-ы на совпадения:
    // - если нахожу несовпадающий элемент, то возвращаю подстроку до этого элемента
    // - если все элементы совпадают, вывожу элемент массива, который меньшей длины

    public static String longestCommonPrefix(String[] strings) {

        if (strings == null || strings.length == 0) {
            return "";
        }
            // сортировка массива
        Arrays.sort(strings);

        String first = strings[0];
        String last = strings[strings.length - 1];
            // Нахожу строку минимальной длины
        int minLength = Math.min(first.length(), last.length());
            // прохожу по каждому элементу подстроки
        for (int i = 0; i < minLength; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first;

    }
}
