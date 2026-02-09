package Home;

/**
 * Написать метод, который принимает строку и целочисленный ключ k
 * и шифрует строку с помощью шифра Цезаря.
 * <p>
 * Пример:
 * <p>("hello", 5) --> mjqqt
 * <p>("bottle of water", 15) --> qdiiat du lpitg
 * <p>("explained to the tester that its not a bug its a feature", 25) --> dwokzhmdc sn sgd sdrsdq sgzs hsr mns z atf hsr z edzstqd
 */
public class CesarsCode {
    public static void main(String[] args) {
//        String str = "hello";
//        int shift = 5;
//        String str = "bottle of water";
//        int shift = 15;
        String str = "explained to the tester that its not a bug its a feature";
        int shift = 25;
        CesarsCode cc = new CesarsCode();
        System.out.println(cc.encryptedString(str, shift));
        System.out.println(cc.encryptedStringUnivers(str, shift));
    }

    public String encryptedString(String str, int shift) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : chars) {
            int shifted = ch + shift;
            char newChar;

            if (ch == ' ') {
                newChar = ch;
            } else if (shifted <= 'z') {
                newChar = (char) (ch + shift);
            } else {
                newChar = (char) ('a' + (shifted - 'z' - 1));
            }
            sb.append(newChar);
        }

        String encrypted = sb.toString();
        return encrypted;
    }

    public String encryptedStringUnivers(String str, int shift) {
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                sb.append(' ');
            } else {
                int pos = ch - 'a';
                int newPos = (pos + shift) % 26;
                sb.append((char) ('a' + newPos));
                // int newPos = (pos + shift % 26 + 26) % 26; // для отрицательных
            }
        }
        return sb.toString();
    }
}
