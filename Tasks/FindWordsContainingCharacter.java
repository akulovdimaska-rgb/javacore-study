package Tasks;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static List<Integer> findWordsContainingCharacter(String[] words, char x) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(String.valueOf(x))) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"leet", "code"};
        char x = 'e';
        System.out.println(findWordsContainingCharacter(words, x));

    }
}