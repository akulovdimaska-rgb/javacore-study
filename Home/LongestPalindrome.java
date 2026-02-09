package Home;
// 409 LongestPalindrome
//Дана строка s, состоящая из строчных или прописных букв. Верните число - длину самого длинного палиндрома,
// построенного с помощью заданных букв.
//Буквы чувствительны к регистру, например, "Aa" не считается палиндромом.
//Пример 1:
//Input: s = «abccccba»
//Output: 7
//Пояснение: Самый длинный палиндром, который можно составить, — «dccaccd», его длина равна 7.

//Пример 2:
//Входные данные: s = «a»
//Выходные данные: 1
//Объяснение: Самый длинный палиндром, который можно составить, — это «a», его длина равна 1.

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {
    public int longestPal(String s) {
        Set<Character> set = new HashSet<>(); //Используем HashSet для сохранения ключей
        int pairs = 0;
        for (char c : s.toCharArray()) {    // преобразуем String в массив Char
            if (set.contains(c)) {          // если Set уже содержит ключ,
                set.remove(c);              // то удаляем существующий
                pairs++;                    // и добавляем единицу в счётчик пар
            } else {                        // если такого ключа нет,
                set.add(c);                 // то вносим значение в сет
            }
        }
        // return set.isEmpty() ? pairs * 2 : pairs * 2 + 1; // если палиндром четной длины, то умножаем на 2,

        if (set.isEmpty()) {
            return pairs * 2;
        } else {
            return pairs * 2 + 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = "Aabccccdd";
        int result = lp.longestPal(s);
        System.out.println(result);
    }
}


