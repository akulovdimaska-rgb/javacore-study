package Home;
// 804. Unique Morse Code Words
// Международный код Морзе определяет стандартную кодировку, в которой каждой букве соответствует последовательность точек и тире следующим образом:
//'a' карты для ".-",
//'b' карты для "-...",
//'c' сопоставляет с "-.-." и так далее.
//Для удобства ниже приведена полная таблица для букв 26 английского алфавита:
//[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
//Дан массив строк words, где каждое слово может быть записано в виде последовательности кода Морзе для каждой буквы.
//Например, "cab" может быть записан как "-.-..--...", что является объединением "-.-.", ".-" и "-...".
//Мы будем называть такое объединение преобразованием слова.
//Верните количество различных преобразований среди всех имеющихся у нас слов.

//"gin" -> "--...-." // g "--."
//"zen" -> "--...-." // z "--.."
//"gig" -> "--...--."
//"msg" -> "--...--."
//There are 2 different transformations: "--...-." and "--...--.".

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        String[] morzeCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] words = {"gin", "zen", "gig", "msg"};

        int result = countUniqueTransformations(words, morzeCode);
        System.out.println("Количество уникальных преобразований: " + result);
    }

    // нам необходимо преобразовать каждую букву в слове в код Морзе (сопоставить каждую букву с кодом Морзе)
    private static String convertToMorzeCode(String word, String[] morzeCode) {
        StringBuilder transformation = new StringBuilder(); //

        //char[] letters = word.toCharArray();              // преобразуем слово в массив символов
        for (char c : word.toCharArray()) {                 // Достаем из []morzeCode значение с индексом по значению из []letters
            transformation.append(morzeCode[c - 'a']);      // накапливаем символы Морзе в итоговой строке
            // мы сделали такую хитрость (c - 'a'), чтобы индексы считались с нуля, т.к.
            // 'a' в кодировке Юникод это 97
        }
        return transformation.toString();                   // по первому слову получаем такую строку: "--...-."
    }

    // Затем мы подсчитываем количество уникальных преобразований, для чего используем HashSet.
    // т.е. дубликаты не будут добавляться.
    private static int countUniqueTransformations(String[] words, String[] morzeCode) {
        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            String resultTransformation = convertToMorzeCode(word, morzeCode);
            uniqueTransformations.add(resultTransformation);
        }

        return uniqueTransformations.size();
    }
    // Если использовать ArrayList, то придется проверять вручную дубликаты через contains
    //if (!transformations.contains(code)) { // Проверка вручную!
    //        transformations.add(code);
    //    }
    // Метод contains() работает медленнее для больших списков (O(n) против O(1) у HashSet).
}
