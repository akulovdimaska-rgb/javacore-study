package Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Учитывая массив строк words, верните слова, которые можно напечатать, используя буквы алфавита только в одной строке американской клавиатуры, как показано на изображении ниже.
//Обратите внимание, что строки нечувствительны к регистру, то есть строчные и прописные буквы одной и той же строки считаются находящимися в одной строке.
//
//На американской клавиатуре:
//первая строка состоит из символов "qwertyuiop",
//вторая строка состоит из символов "asdfghjkl", и
//третья строка состоит из символов "zxcvbnm".
//Input: words = ["Hello","Alaska","Dad","Peace"]
//Output: ["Alaska","Dad"]


public class KeyboardRow1 {

    public static String[] findWords(String[] words) {
        String row1 = "qwertyuioop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        List<String> list = new ArrayList<>();
        for (String word : words) {
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;

            for (int i = 0; i < word.length(); i++) {
                // gt
                String ch = String.valueOf(word.charAt(i)).toLowerCase();
                if (row1.contains(ch)) {
                    count1++;
                } else if (row2.contains(ch)) {
                    count2++;
                } else {
                    count3++;
                }
            }
            if (count1 == word.length() || count2 == word.length() || count3 == word.length()) {
                list.add(word);
            }

        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow1 kr = new KeyboardRow1();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = kr.findWords(words);
        System.out.println(Arrays.toString(result));
    }
}
