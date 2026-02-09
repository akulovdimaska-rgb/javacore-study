package Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCharacter {
    // 2942. Find Words Containing Character
    // Представлен массив слов с индексом 0 и символом x.
    // Требуется вернуть массив индексов, представляющих слова, содержащие символ x.
    // Обратите внимание, что возвращаемый массив может быть в любом порядке.

// Example 1:
//Input: words = ["leet","code"], x = "e"
//Output: [0,1]
//Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
//Example 2:
//Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
//Output: [0,2]
//Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
//Example 3:
//Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
//Output: []
//Explanation: "z" does not occur in any of the words. Hence, we return an empty array.

// Ограничения:
    //1 <= words.length <= 50
    //1 <= words[i].length <= 50
    //x is a lowercase English letter.
    //words[i] consists only of lowercase English letters.

    public List<Integer> findCharacter(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();                  // создаем новый массив индексов, в элементах которых содержится искомый символ
        for (int i = 0; i < words.length; i++) {                // во внешнем цикле проходим по массиву, содержащему слова
            for (int j = 0; j < words[i].length(); j++) {       // во внутреннем цикле проходим по буквам в слове
                if (words[i].charAt(j) == x) {                  // если чар из слова равен искомому чару,
                    ans.add(i);                                 // то мы добавляем его в массив индеков и завершаем проверку
                    break;
                }
            }
        }
        return ans;                                             // возвращаем массив индексов

    }

    public static void main(String[] args) {
        FindCharacter fc = new FindCharacter();
        String[] words = {"leet", "code"};
        // String[] words = {"abc","bcd","aaaa","cbc"};
        char x = 'e';
        // char x = 'a';
        Integer[] result = fc.findCharacter(words, x).toArray(new Integer[0]);
        System.out.println(Arrays.toString(result));
    }

}
