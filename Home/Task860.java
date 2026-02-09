package Home;
// В киоске с лимонадом каждый стаканчик стоит $5. Покупатели стоят в очереди, чтобы купить у вас лимонад,
// и заказывают по одному (в порядке, указанном в купюрах). Каждый покупатель купит только один стаканчик лимонада и
// заплатит купюрой в $5, $10 или $20.
// Вы должны дать каждому покупателю правильную сдачу, чтобы в итоге покупатель заплатил $5.
// Вернуть true или false

public class Task860 {
    public static void main(String[] args) {
        int[] bills = {5, 10, 10, 20};
        // int[] bills = {5, 5, 5, 10, 10, 20};
        // int[] bills = {5, 5, 10, 10, 20};
        System.out.println(canGiveChange(bills));
    }

    public static boolean canGiveChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;

        for (int bill : bills) {        // можно использовать for-each, т.к. нет необходимости в индексах
            if (bill == 5) {            // если клиент приходит с 5$, то
                countFive++;            // кладём в кассу 5-ку
            } else {
                if (bill == 10) {           // если приходит 10$, то
                    countTen++;             // кладём в кассу 10$
                    countFive--;            // даём сдачу 5$
                } else {
                    if (bill == 20) {   // если приходит 20$
                        if (countTen >= 1 && countFive >= 1) { // проверяем наличие хотя бы одной 10-ки и 5-ки в кассе
                            countTen--;                        // даём сдачу 10-кой
                            countFive--;                       // даём сдачу 5-кой
                        } else {
                            if (countFive >= 3) {                   // если в кассе нет 10-ток, но есть три 5-ки
                                countFive -= 3;                     // даём сдачу тремя 5-тёрками
                            } else {
                                return false;                           // если ни одно из условий не выполнилось возвращаем false
                            }
                        }
                    }
                }
            }

        }
        for (int bill : bills) {
            if (bill == 5) {            // если клиент приходит с 5$, то
                countFive++;
            } else if (bill == 10) {
                if (countFive == 0) {
                    return false;
                }
                countTen++;
                countFive--;
            } else {
                if (countTen >= 1 && countFive >= 1) { // проверяем наличие хотя бы одной 10-ки и 5-ки в кассе
                    countTen--;                        // даём сдачу 10-кой
                    countFive--;                       // даём сдачу 5-кой
                } else {
                    if (countFive < 3) {                   // если в кассе нет 10-ток, но есть три 5-ки
                        return false;
                    }
                    countFive -= 3;                           // если ни одно из условий не выполнилось возвращаем false

                }
            }
        }

        return true;        // если всё сложилось, возвращаем true
    }
}
