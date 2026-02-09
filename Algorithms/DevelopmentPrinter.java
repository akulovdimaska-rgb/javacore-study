package Algorithms;

import com.sun.source.tree.IfTree;

import java.util.concurrent.ThreadLocalRandom;

public class DevelopmentPrinter {
    // чтобы код был гибче, можно обявить массив как статическое поле класса
    // так может выглядеть более структурированным и легче добавлять новые данные
    private static final String[] QUOTES = {
            "Да здравствует развитие! 🎶 ",
            "А ещё правильные отступы и фигурные скобки! 👍",
            "Компилятор — ваш самый строгий учитель 👨🏫",
            "Каждая ошибка — шаг к мастерству! 💪",
    };

    public static void main(String[] args) {
        printMotivation();

    }

    public static void printMotivation() {
//код до улучшения
//        String[] quotes = {
//                "Да здравствует развитие! 🎶 ",
//                "А ещё правильные отступы и фигурные скобки! 👍",
//                "Компилятор — ваш самый строгий учитель 👨🏫",
//                "Каждая ошибка — шаг к мастерству! 💪",
//        };
//        if (quotes.length > 0) {
//            int randomIndex = (int) (Math.random() * quotes.length); // (int) - приведение типов
//            System.out.println(quotes[randomIndex]);

        if (QUOTES.length > 0){
            int randomIndex = ThreadLocalRandom.current().nextInt(QUOTES.length);
            //ThreadLocalRandom - защищает от ошибок приведения типов
            System.out.println(QUOTES[randomIndex]);
        } else {
            System.out.println("Массив пуст! 😎");
        }
    }
}
