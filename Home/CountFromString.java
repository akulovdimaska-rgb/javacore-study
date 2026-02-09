package Home;

public class CountFromString {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество цифр в строке : " + countDigits2(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int digitCount = 0;
        for(char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        return digitCount++;
    }

    public static int countDigits2(String string) {
        return (int) string.chars()
                .filter(Character::isDigit) //.filter(codePoint -> Character.isDigit(codePoint))
                .count();
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int letterCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                letterCount++;
            }
        }
        return letterCount;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int spaceCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isWhitespace(string.charAt(i))) {
                spaceCount++;
            }
        }
        return spaceCount;
    }
}
