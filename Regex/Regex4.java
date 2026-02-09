package Regex;

public class Regex4 {
    public static void main(String[] args) {
        String s1 = "Privet,  moy  drug! Kak idet       izuchenie   Java?";
        System.out.println(s1);
//        s1 = s1.replace("Java", "SQL"); // метод Replace меняет слова в стрингах
//        System.out.println(s1);
//        s1 = s1.replaceAll(" {2,}", " ");
//        System.out.println(s1);
//        s1 = s1.replaceAll("\\bi\\w+", "****");
//        System.out.println(s1);
        s1 = s1.replaceFirst("\\bi\\w+", "****");
        System.out.println(s1);
    }
}
