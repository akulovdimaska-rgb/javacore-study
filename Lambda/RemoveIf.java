package Lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIf {
    static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Privet");
        al.add("poka");
        al.add("Ok");
        al.add("Uchim Java");
        al.add("A imenno Lambda");
        //al.removeIf(e -> e.length() < 5); написание может быть разным, первый вариант лучше, если используем один раз
        Predicate<String> p = element -> element.length() < 5;
        System.out.println(al);
    }
}
