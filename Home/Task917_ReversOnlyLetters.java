package Home;

/**
 * 917. Reverse Only Letters
 * Переставить буквы в обратном порядке
 * Ввод: s = "a-bC-dEf-ghIj"
 * Вывод: "j-Ih-gfE-dCba"
 */
public class Task917_ReversOnlyLetters {
    static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        System.out.println(reversLetters(s));
    }
    /**
     * Будем использовать два указателя))
     * 1) если символ не буква, то смещаю один указатель, влево или вправо, соответственно
     * 2) если оба символа буквы, то меняю местами через временную переменную
     * 3) смещаю оба указателя
     */
    public static String reversLetters(String s) {
            //преобразуем Стринг в массив символов
        char[] simbols = s.toCharArray(); //"j-Ih-gfE-dCba"
            //будем использовать два указателя
        int left = 0;
        int right = simbols.length-1;
            //указатели будут двигаться не симметрично
        while (left < right) {
            char temp;
            if (!Character.isLetter(simbols[left])) {
                left++;
            } else if (!Character.isLetter(simbols[right])) {
                right--;
            } else {
                temp = simbols[left];
                simbols[left] = simbols[right];
                simbols[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(simbols);
    }
}
