package Home;

import java.util.List;

/**
 * Самое частое слово
 * Условие
 * Дана строка text, состоящая из слов, разделённых одним или несколькими пробелами.
 * Нужно найти одно слово, которое встречается чаще всего в строке, и вернуть его.
 * •  Сравнение слов регистронезависимое
 * •  Если таких слов несколько — верни любое
 * •  Если строка пустая или состоит только из пробелов — верни пустую строку ""
 * Input:
 * "Java streams are powerful and java Streams"
 * Output:
 * "java"
 */
public class ChastotaSlov {
    public static void main(String[] args) {
        String string = "Java streams are, powerful, and   java Streams";
        System.out.println(ChastotaSlov.getFrequentlyWord(string));
    }

    public static String getFrequentlyWord(String word) {

return "";
    }

}
