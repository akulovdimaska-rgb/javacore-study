package Home;
// 868_Binary Gap Бинарный взрыв
// Дано позитивное число n
// Необходимо вернуть наибольшую дистанцию между двумя единицами, а если единица одна, вернуть 0

import java.util.Scanner;

public class Task868 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = scanner.nextInt();
        scanner.close();
        System.out.println("Двоичное представление числа: " + Integer.toBinaryString(n));
        System.out.println("Максимальное расстояние: " + binaryGap(n));
    }

    public static int binaryGap(int n) {
        int maxDistance = 0;                // Вводим переменные: - наибольшее расстояние
        int lastPosition = -1;              //                    - последняя позиция - мы пока не встретили 1
        int currentPosition = 0;            //                    - текущая позиция
                                            // n=22 -> 10110
        while (n > 0) {
            if ((n & 1) == 1) {                         // условие, если крайний правый бит = 1
                if (lastPosition != -1) {               // гарантия того, что мы нашли вторую единицу
                    maxDistance = Math.max(maxDistance, currentPosition - lastPosition); // вычисляем наибольшую дистанцию
                }
                lastPosition = currentPosition;        // запоминаем позицию встретившейся единицы
            }
            n = n >> 1;
            currentPosition++;
        }
        return maxDistance;
    }

}
