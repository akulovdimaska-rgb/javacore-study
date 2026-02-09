package Home;
// Задача 557.Reverse Words in a String III
// перевернуть каждое слово в предложении, но не предложение

public class ReverseWords {
    public String reverseWords(String myString) {

        // разбиваем предложение на слова
//        String []words = new StringBuilder(myString).reverse().toString().split(" ");
//

        String []words = myString.split(" "); // создаем массив из подстрок, в который добавляем отдельные слова,
                                                    // используя разделитель, который определяется с помощью регулярного выражения
        StringBuilder resulted = new StringBuilder(); // результирующий Стрингбилдер

        for (int i =0; i<words.length; i++) {       // проходим по всему массиву подстрингов words,
            StringBuilder reversed = new StringBuilder(words[i]); // Стрингбилдер для каждого i-тый его элемента (слова)
            reversed.reverse();                                   // разворачиваем  каждый i-тый элемент
            resulted.append(reversed).append(" ");    // результат добавляем в конец из Стрингбилдера reversed + пробел
        }

        return resulted.toString().trim();            // возвращаем результат из Стрингбилдера result в строку
                                                      // и с помощью trim удаляем последний пробел
    }
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String myString = "Let's take LeetCode contest";
        //String[array] = myString.split(" ");
        // Output: "s'teL ekat edoCteeL tsetnoc"
        String result = rw.reverseWords(myString);
        System.out.println(result);
    }
}
