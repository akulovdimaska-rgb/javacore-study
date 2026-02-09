package Home;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class Task824 {

    //Вам дана строка sentence, состоящая из слов, разделённых пробелами. Каждое слово состоит только из строчных и заглавных букв.
    //
    //Мы хотели бы перевести это предложение на «козлиную латынь» (вымышленный язык, похожий на «свиную латынь»). Правила «козлиной латыни» следующие:
    //
    //Если слово начинается с гласной ('a', 'e', 'i', 'o' или 'u'), добавьте "ma" в конец слова.
    //Например, слово "apple" становится "applema".
    //Если слово начинается с согласной (т. е. не с гласной), удалить первую букву и добавьте её в конец, затем добавьте "ma".
    //Например, слово "goat" становится "oatgma".
    //Добавьте одну букву 'a' в конец каждого слова в соответствии с его порядковым номером в предложении, начиная с 1.
    //Например, к первому слову добавляется "a" в конце, ко второму слову добавляется "aa" в конце и так далее.
    //Верните последнее предложение, представляющее собой перевод предложения на козью латынь.

    // Разбить строку на подстринги, создать массив
    // Создаем пустой список для сохранения результата
    // Объявить переменную String с гласными, как заглавными, так и строчными
    // Проверить каждое слово на наличие в начале согласной (не гласной)
    // Если согласной нет добавляем в конце суффикс "ма"
    // Добавляем в конец букву "а"
    // Необходим счётчик для добавления в каждое последующее слово на одну букву "а" больше
    // Сохраняем преобразованные слова в список

    public static void main(String[] args) {
        String sentence = "I speak Goat Latin";
        //Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

        //String sentence = "The quick brown fox jumped over the lazy dog";
        //Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"


        System.out.println(convertToGoalLatin(sentence));
    }

    public static String convertToGoalLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        String suffix = "ma";
        String endLetter = "a";

        String[] words = sentence.split(" ");                 // разбил строку по пробелу, т.к. нет других символов в строке
        List<String> newSentence = new ArrayList<>();               // создали для сохранения всех преобразованных слов

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            StringBuilder newWord = new StringBuilder();
                        // {I, speak, Goat, Latin}
            if (vowels.indexOf(word.charAt(0)) != -1) {             // Если гласная содержится в начале слова из массива
                // можно было бы написать так: if (vowels.contains(String.valueOf(word.charAt(0))))
                newWord.append(word).append(suffix); //I + ma
            } else {
                newWord.append(word.substring(1)) //goat
                       .append(word.charAt(0))
                       .append(suffix);             // соединяем начиная со второй буквы + первая в конец
            }                                       // oat + g + ma
            // добавляем 'a' в s
            newWord.append(endLetter.repeat(i + 1));                           // добавляем на одну букву "а" больше (так можно делать с Java11+)

            newSentence.add(newWord.toString());
            //можно эту часть кода выразить через обычный цикл
            //for (int j = 0; j < i + 1; j++){
            //newWord += "a";
            //}

        }

        return String.join(" ", newSentence); // соединяем все элементы списка через пробел

    }

}
