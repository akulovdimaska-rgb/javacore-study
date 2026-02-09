package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        String s = "Ivanov Vasiliy, Russia, Moskow, Lenin street, 15" +
                "Flat 48, email: vivakov@mail.ru, 19 Postcode: AA99, phone Number: +123456789";
        Pattern pattern = Pattern.compile("\\+ \\d(8)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
