package Home;

import java.util.*;
import java.util.stream.Collectors;

//Дана строка paragraph и массив строк с запрещёнными словами banned, надо вернуть самое часто встречающееся слово,
//которое не является запрещённым.Гарантируется, что хотя бы одно слово не является запрещённым и что ответ уникален.
//Слова в paragraphне чувствительны к регистру, и ответ должен быть возвращён в нижнем регистре.
//Обратите внимание, что слова не могут содержать знаки препинания.
public class Task819 {
    // 1. Необходимо привести paragraph в удобный для работы вид:
    // - заменить знаки препинания на пробелы
    // - перевести все слова в нижний регистр
    // 2. Разделить текст на отдельные слова
    // 3. Подсчитать слова, которые не содержатся в banned (и внести их в HashMap ключ (слово) и значение (сколько оно встречается)
    // 4.  По максимальному количеству повторений вернуть самое повторяющееся слово


    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(mostCommonWord2(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        //через регулярные выражения можно заменить все знаки пунктуации на пробелы,
        String clearPunctuationSimbols = paragraph.replaceAll("\\p{Punct}", " ")
                .toLowerCase();                                         //а затем переводим в нижний регистр.

        String[] words = clearPunctuationSimbols.split("\\s+");   //Делим на отдельные слова и записываем в массив.

        Set<String> bannedSet = new HashSet<>();                        // Здесь мы создали Set для фильтра запрещённых слов
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());                          // тоже переводим в нижний регистр
        }

        Map<String, Integer> wordsCount = new HashMap<>();
        // подсчитываем как часто оно встречается в String[] words
        for (String word : words) {                                     // для этого можно использовать for-each цикл
            if (!word.isEmpty() && !bannedSet.contains(word)) {         // два условия: слово не пустое и нет в bannedSet
                wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1); //и записываем в HashMap
            }                                                           // Оптимизация при использовании getOrDefault - сокращаем код
        }                                                               // не надо вводить дополнительный цикл

        String mostFrequancy = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {  // с помощь цикла for-each пробегаем по HashMap
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();                            // благодаря entry у нас есть прямой доступ к паре ключ/значение
                mostFrequancy = entry.getKey();
            }
        }
        return mostFrequancy;
    }


    public static String mostCommonWordStream(String paragraph, String[] banned) {
        // создаем список запрещенных слов
        Set<String> bannedSet = Arrays.stream(banned)
                .map(String::toLowerCase)                         // перевели в нижний регистр
                .collect(Collectors.toSet());

        return Arrays.stream(paragraph.toLowerCase()               // перевели в нижний регистр
                        .split("[\\p{Punct}\\s]+"))      // разбили на слова без знаков препинания
                .filter(word -> !word.isEmpty())             // фильтруем пустые слова
                .filter(word -> !bannedSet.contains(word))   // фильтруем забаненые слова
                .collect(Collectors.groupingBy(word -> word,
                Collectors.counting()))
                .entrySet().stream()                                // не работает!!! преобразование в поток
                .max(Map.Entry.comparingByValue())                  // затем находим максимальное значение
                .map(Map.Entry::getKey)                             // и выбираем по нему слово
                .orElse("");                                        // Это, если результата не будет

    }

    public static String mostCommonWord2(String paragraph, String[] banned) {
        // Создаем множество запрещенных слов
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        Map<String, Integer> wordCount = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();
        String mostFrequent = "";
        int maxCount = 0;

        // Обрабатываем каждый символ в строке
        for (int i = 0; i <= paragraph.length(); i++) {
            char c = i < paragraph.length() ? paragraph.charAt(i) : ' ';

            // Если символ буквенный, добавляем к текущему слову (в нижнем регистре)
            if (Character.isLetter(c)) {
                currentWord.append(Character.toLowerCase(c));
            }
            // Если символ не буквенный и текущее слово не пустое
            else if (currentWord.length() > 0) {
                String word = currentWord.toString();

                // Проверяем, не запрещено ли слово
                if (!bannedSet.contains(word)) {
                    // Обновляем счетчик
                    int count = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, count);

                    // Проверяем, не стало ли это слово самым частым
                    if (count > maxCount) {
                        maxCount = count;
                        mostFrequent = word;
                    }
                }

                // Сбрасываем текущее слово
                currentWord.setLength(0);
            }
        }

        return mostFrequent;
    }

}


