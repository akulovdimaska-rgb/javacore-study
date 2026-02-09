package Home;

import java.util.Arrays;
//520. Мы считаем, что использование заглавных букв в слове является правильным, если выполняется одно из следующих условий:
//
//Все буквы в этом слове заглавные, например, "USA".
//Все буквы в этом слове не заглавные, как "leetcode".
//Только первая буква в этом слове заглавная, как "Google".
//Учитывая строку word, верните true, если в ней правильно использованы заглавные буквы.

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int capital = 0;

        for (char c : word.toCharArray()) { // с помощью форич преобразуем строку в массив символов

            if (Character.isUpperCase(c)) { //
                capital++;                  // увеличиваем счётчик если встречается заглавная буква
            }
        }

        if (capital == word.length() || capital == 0) { // если количество заглавных букв равно длине слова или = 0
        return true;                                //тогда возвращаем true
        }
        char ch = word.charAt(0);
        return capital == 1 && Character.isUpperCase(ch); // если первая и заглавная буква
    }

    public boolean detectCapitalUse2(String word) {
        long lg = word.chars()
                //.filter(e -> Character.isUpperCase((char) e))
                .filter(Character::isUpperCase)
                .count();

        if (lg == word.length() || lg == 0) {
            return true;
        }
        char ch = word.charAt(0);
        return lg == 1 && Character.isUpperCase(ch);
    }


    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        //String word = "USA";
        //String word = "leetcode"; // ['l', 'e', 'e', 't', 'c', 'o', 'd', 'e']
        String word = "google";
        boolean result = detectCapital.detectCapitalUse2(word);
        System.out.println(result);
    }
}
