package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String s1 = "ABD ABC ABCE ABDCABDFABDOPGABCH";
        Pattern pattern1 = Pattern.compile("AB[C-E]OP");
        Matcher matcher = pattern1.matcher(s1);
        while (matcher.find()){
//            System.out.println(matcher.group());
            System.out.println("Position:"+matcher.start()+" "+matcher.group());

        }
    }
}
