package Home;

//Задача: «Проверка симметричности буквы»
//        Условие:
//        Напишите метод, который принимает символ char и возвращает:
//
//        true - если буква симметрична относительно вертикальной оси (выглядит одинаково в зеркальном отражении);
//
//        false - в остальных случаях.
//
//        Суть: некоторые буквы при зеркальном отражении по вертикальной оси выглядят так же, как исходная
//        (например, A, H, I), а другие нет (например, B, C, D).

//AHIMOTUVWXY - все латинские заглавные буквы, которые являются симметричными относительно вертикальной оси


public class MirrorChars {
    public static void main(String[] args) {
        char ch1 = 'A';
        char ch2 = 'B';

        MirrorChars mirrorChars = new MirrorChars();
        System.out.println(mirrorChars.isSymmetrical(ch2));
    }

    public boolean isSymmetrical(char ch) {
        char[] symmetrical = {'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y'};

        for (char sim : symmetrical) {
            if (ch == sim) {
                return true;
            }
        }
        return false;
    }

}
