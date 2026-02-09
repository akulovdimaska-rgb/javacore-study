package Home;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Tasks {


    // переносить буквы слева направо в строке 1, чтобы получить строку 2

    public boolean isTransform(String s1, String s2) {

        if (s1.length() != s2.length()) {                           // лучше переименовать s1 и s2 в читаемые имена
            return false;
        }

        char[] ch1 = s1.toCharArray();

        for (int i = 0; i <= s1.length(); i++) {
            char temp = ch1[0];
            char[] arrayTemp = new char[ch1.length];

            System.arraycopy(ch1, 1, arrayTemp, 0, arrayTemp.length - 1); // c 23 по 26 лучше перенести в другой метод
            arrayTemp[arrayTemp.length - 1] = temp;
            ch1 = arrayTemp;
            String s3 = new String(ch1);

            if (s3.equals(s2)) {
                return true;
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "cdeab";

        Tasks test = new Tasks();
        System.out.println(test.isTransform(s1, s2));
    }
}



