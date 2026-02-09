package Tasks;

public class Structura {

    /** Пример реализации простого метода, который суммирует 2 целых числа.
     *  private - метод доступен только в рамках этого класса (Tasks.Structura)
     *  int - результатом работы метода будет переменная типа int. То есть метод вернет целое число.
     *  int parameter1, int parameter2 - принимаемые параметры. Наш метод будет их суммировать.
     *      Имена параметров абсолютно не важны и не пересекаются с чем-то вне метода.
     *      Используются исключительно локально.
     *  К return пишем то, что мы видим как результат работы метода. То, что он вернет.
     */

    /*private static int summ (int parameter1, int parameter2) {
        System.out.println("Выведем в консоль результат сложения чисел " + parameter1 + " и " + parameter2);
        return parameter1 + parameter2;
    }*/

    public static void main(String[] args) {
        /*
        // Ниже - накидали как будем реализовать суммирование 2 чисел. Дальше будем вызывать метод.
        int a = 5; // переменная инициализирована
        int b; // переменная объявлена
        b = 10; // переменная ранее была объявлена и теперь инициализирована
        // int b = 20; // здесь повторно инициализирована переменная b и компилятор ругается - scope - область видимости
        int c = a+b;
        System.out.println(c);
        */


        // ранее мы создали метод summ(int parameter1, int parameter2), который принимает на вход 2 целых числа и возвращает их сумму.
        // теперь будем вызывать метод.
        // System.out.println(summ(5, 6));
        // готово.

        // теперь вызовем такой же метод, только из другого класса.

        ArithmeticalOperations arOperations = new ArithmeticalOperations(10, 20);

        arOperations.summation(arOperations.summand1, arOperations.summand2);
        System.out.println(arOperations.summation(arOperations.summand1, arOperations.summand2));

    }
}
