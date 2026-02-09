package Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex3 {
    public static void main(String[] args) {
        String s = "Ivanov Vasiliy, Russia, Moskow, Lenin street, 15" +
                "Flat 48, email: vivakov@mail.ru, 19 Postcode: AA99, phone Number: +123456789";
        String s2 = "chuck@mail.com";
        boolean result = s2.matches("\\w+@\\w+\\.(com|ru)");//шаблон сверяет на соответсвие наших символов
        System.out.println(result);


        String[] array= s.split(" ");
        System.out.println(Arrays.toString(array));
    }
}

