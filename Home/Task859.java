//package Home;
//// Нам даны две String s и goal, и мы должны проверить, можно ли поменять местами символы в двух позициях String s так, чтобы String s стала равна goal
//
//// Надо проверить:
//// 1. Стоки должны иметь одинаковую длину - иначе вернём false
//// 2. Должны иметь только одинаковые символы - иначе вернём false
//// Если строки уже равны:
//// 3. Если один символ встречается минимум 2 раза, то его можно поменять - иначе вернём false - символы уникальны
//// 5. Местоположение должно отличаться только у 2-х символов, т.е.  1 < x < 3 - иначе вернём false
//
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Task859 {
//    public static void main(String[] args) {
//        String s = "ab";
//        String goal = "ba";
//        // String s = "ab";
//        // String goal = "ab";
//        // String s = "aa";
//        // String goal = "aa";
//    }
//
//    public static boolean canSwapLetters(String s; String goal) {
//        public static boolean canSwapLetters(String s, String goal) {
//            // 1. Проверка одинаковой длины
//            if (s.length() != goal.length()) {
//                return false;
//            }
//
//            // 2. Если строки идентичны - проверяем наличие дубликатов
//            if (s.equals(goal)) {
//                return hasDuplicateChars(s);
//            }
//
//            // 3. Проверка двух несовпадений с возможностью обмена
//            return hasExactlyTwoMismatches(s, goal);
//        }
//
//        // Проверка наличия дубликатов символов
//        private static boolean hasDuplicateChars(String s) {
//            Set<Character> uniqueChars = new HashSet<>();
//            for (char c : s.toCharArray()) {
//                if (!uniqueChars.add(c)) { // Если символ уже был в Set
//                    return true; // Нашли дубликат
//                }
//            }
//            return false;
//    }
//            // Проверяю на дубликаты - вспомогательный метод
//    private static boolean hasDuplicateChars(String s){
//        Set<Character> chars = new HashSet<>();
//        char[] charArray = s.toCharArray();
//        for (char c : charArray){
//            chars.add(c);
//        }
//        int uniqueCharsCount = chars.size();                            // Получаем количество уникальных символов
//        int totalCharsCount = s.length();                               // Получаем общее количество символов в строке
//
//        if (uniqueCharsCount < totalCharsCount){                        // Определяем, есть ли дубликаты
//            return true;
//        } else {
//            return false;
//        }
//        // return uniqueCharsCount < totalCharsCount                    // Оптимизация без if-else
//        // return chars.size() < s.length();                            // Можно оптимизировать в одну строку без if-else и int переменных
//    }
//
//    private static boolean hasExactlyTwoMismatches(String s; String goal){
//        List<Integer> mismatches = new ArrayList<>();                   // Необходим список для сохранения индексов несовпадений
//
//        for (int index = 0; index < s.length(); index++) {
//
//            char charInS = s.charAt(index);                             // Получаем текущие символы из обеих строк
//            char charInGoal = goal.charAt(index);
//
//            boolean charsAreDifferent = (charInS != charInGoal);        // сравниваем символы
//
//            if (charsAreDifferent) {
//                mismatches.add(index);
//                if (mismatches.size() > 2) {                            // Если есть два совпадения, то можно выходить
//                    return false;
//                }
//            }
//        }
//        // Проверяем, что число несовпадений ровно 2
//        if (mismatches.size() != 2) {
//            return false;
//        }
//        // Проверяем, можно ли поменять символы местами
//        int i = mismatches.get(0);
//        int j = mismatches.get(1);
//        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
//    }
//
//}



