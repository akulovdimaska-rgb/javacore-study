package Home;
// 925. Long Pressed Name. Долго нажатое имя))
// На входе два слова: одно - это набираемое имя, а второе написано со случайным нажатием клавиши.
// Вернуть true, если имя действительно написано со случайным нажатием
// Будем проверять поочередно соответствие букв в обоих строках.
// Идём, пока не вышли за пределы обеих строк.
// Если сначала равны, то сдвигаем оба указателя вперед (цикл) и проверяем соответствие букв в name и taped
//
// Если не соответствуют - проверяем соответствие текущего указателя typed предыдущему указателю taped
// если соответствуют, то смещаем указатель typed вперёд
// если typed текущий не соответствует предыдущем и не соответствует name, то возвращаем false
//

public class Task925 {

    static void main() {
        String name = "alex";
        String typed = "aaleexx";
        System.out.println(isTapedName(name, typed));
    }

    public static boolean isTapedName(String name, String typed) {
        if (name.isEmpty()) {
            return typed.isEmpty();
        }

        char[] charsName = name.toCharArray();
        char[] charsTyped = typed.toCharArray();
        int nameIndex = 0;
        int typedIndex = 0;

                            // Условие будет выполняться, пока один из индексов не дойдёт до конца массива
        while (nameIndex < charsName.length && typedIndex < charsTyped.length) {
            if (charsName[nameIndex] == charsTyped[typedIndex]) {
                nameIndex++;
                typedIndex++;
                            // Здесь важен порядок проверки условий, чтобы не было ArrayIndexOutOfBoundsException
            } else if (typedIndex > 0 && charsTyped[typedIndex] == charsTyped[typedIndex - 1]) {
                typedIndex++;
            } else {
                return false;
            }
        }

                            // Можно добавить дополнительную проверку, если name длиннее typed
        if (nameIndex < charsName.length) {
            return false;
        }
                            // Здесь мы проверяем, что все оставшиеся символы равны последнему символу в charsName
        while (typedIndex < charsTyped.length) {
                            // Здесь надо обязательно привязаться к charsName.length - 1, чтобы не было выхода за пределы массива
            if (charsTyped[typedIndex] != charsName[charsName.length - 1]) {
                return false;
            }
            typedIndex++;
        }
        return true;
    }

    public static boolean isTapedName2 (String name, String typed) {
        int i = 0, j = 0;

        while (j < typed.length()) {                                            // пока не пройдём всю строку
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {   // Если символы совпадают - двигаем оба указателя
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Повторяющийся символ в typed - пропускаем
                j++;
            } else {
                // Если символы не совпадают и не повторяются
                return false;
            }
        }

        // Проверяем, что все символы имени были обработаны
        return i == name.length();
    }

}
