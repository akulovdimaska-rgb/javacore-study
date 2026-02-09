package Home;
// 806
//Вам дана строка s из строчных букв английского алфавита и массив widths с указанием ширины в пикселях каждой строчной буквы английского алфавита. В частности, widths[0] — это ширина 'a', widths[1] — это ширина 'b' и так далее.
//Вы пытаетесь написать s в несколько строк, где каждая строка не длиннее, чем 100 пикселей. Начиная с начала s, напишите столько букв на первой строке, чтобы общая ширина не превышала 100 пикселей. Затем, с того места, где вы остановились в s, продолжайте писать столько букв, сколько сможете, на второй строке. Продолжайте в том же духе, пока не напишете все s.
//Вернуть массивresultдлиной 2, в котором:
//result[0] - общее количество строк.
//result[1] Это ширина последней строки в пикселях.

import java.util.Arrays;

public class NumberOfLinesToWriteString {
    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String inputLine = "abcdefghijklmnopqrstuvwxyz";
        //String inputLine ="bbbcccdddaaa";

        System.out.println(Arrays.toString(getQuantityAndCountLines(widths, inputLine)));
    }

    private static int[] getQuantityAndCountLines(int[] widths, String inputLine) {
        int lines = 1;              // создаем переменную для подсчёта количества строк
        int currentLineWidth = 0;   // создаем переменную для подсчёта ширины текущей строки

        int[] result = new int[2];  // можно сразу создать массив, где будем хранить результаты

        char[] line = inputLine.toCharArray(); // преобразуем String в массив char
        // можно метод преобразования внести в for=each
        // for (char c : inputLine.toCharArray()) {
        for (char c : line) {
            int currentLetterWidth = widths[c - 'a'];           // определяем ширину текущей буквы
            if (currentLineWidth + currentLetterWidth <= 100) { // если строка + текущая буква <= 100
                currentLineWidth += currentLetterWidth;         // прибавляем к ширине текущей строки ширину текущей буквы
            } else {
                lines += 1;                                 //если первое условие не выполняется, то будет вторая строка
                currentLineWidth = currentLetterWidth;      // и новая строка будет равна ширине текущей буквы
            }
        }
        //result[0] = lines;
        //result[1] = currentLineWidth;
        //return result;
        // можно не создавать массив в начале метода и не присваивать значения обоим индексам,
        // а написать в компактном виде:
        result[0] = lines;                      // определяем значения индексов в массиве
        result[1] = currentLineWidth;
        return new int[]{lines, currentLineWidth};
    }

   // private static int[] getQuantityAndCountLines2(int[] widths, String inputLine){



}



