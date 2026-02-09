package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class A13_StringSearch {
    public static void main(String[] args) {


        String text =   "aabaabaaaaaabaabaabaabbaaab";
        String sample = "aabaab";

        System.out.println(Arrays.toString(searchNaive(text, sample).toArray()));
        System.out.println(Arrays.toString(prefixFunction(sample)));
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));
    }

    static ArrayList<Integer> searchNaive(String text, String sample) {
        ArrayList<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == sample.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions;
    }

    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }
        // Алгоритм Кнутта-Морриса-Пратта
    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }
}
// Полезные ссылки:
// https://habr.com/ru/post/111449/
// https://habr.com/ru/post/307220/
// https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0tqaVJ2UThyUTBuS1lKSTRaWE5ZTFRsTTBVd3xBQ3Jtc0tuaHZMbzVpYWp3UXhNNlRQanlDaW9jdlRDRXNwMHFoOUQ1VHRnemdvMWY2aHdaT3lkQjcyZXlHbmFLbUNVaVdBMlp5cGxZR2J6QTVwOW9FeG1TaHJNSHM1b0RSaVhkUG5vSlFiUXVPeTU5a2dRUTd4OA&q=https%3A%2F%2Fru.wikipedia.org%2Fwiki%2F%25D0%2590%25D0%25BB%25D0%25B3%25D0%25BE%25D1%2580%25D0%25B8%25D1%2582%25D0%25BC_%25D0%259A%25D0%25BD%25D1%2583%25D1%2582%25D0%25B0_%25E2%2580%2594_%25D0%259C%25D0%25BE%25D1%2580%25D1%2580%25D0%25B8%25D1%2581%25D0%25B0_%25E2%2580%2594_%25D0%259F%25D1%2580%25D0%25B0%25D1%2582%25D1%2582%25D0%25B0&v=bBFg9LXdZA4