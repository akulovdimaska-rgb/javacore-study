package Tasks;

public class Task1446 {
    public static void main(String[] args) {
        String s = "aaaaaleeeeeeeetcodeoooo";
        System.out.println(consecutiveCharacters(s));
    }

    public static int consecutiveCharacters(String s) {
        //1. Преобразуем строку в массив символов
        //2. Ищем повторяющиеся символы, если находим то сохраняем
        // Хорошо бы проверить в начале на пустую строку
        // String[] word = s.split(""); - опитимальнее использовать преобразование строки через charAt

        if (s.isEmpty()) {
            return 0;
        }
        int count = 1;
        int countMax = 1;           // Раз есть проверку на пустую строку, countMax можно задать 1, а не 0
//        for (int i = 0; i < word.length - 1; i++) { // можно заменить код, т.к. будет преобразование - charAt
//            if (word[i].equals(word[i + 1])) {
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
                countMax = Math.max(countMax, count);
            } else {
                count = 1;
            }

//            if (countMax < count) {
//                countMax = count;

        }
        return countMax;
    }
}


