package Home;

/*
У вас есть длинная клумба, на которой некоторые участки уже заняты цветами, а некоторые — нет.
Однако цветы нельзя сажать на соседних участках.

Дано: массив flowerbed, состоящий из 0 и 1, где 0 означает пустой участок, а 1 — занятый, и целое число n.
Необходимо вернуть true, если можно посадить n новых цветов на клумбу, не нарушая правило отсутствия цветов
на соседних участках, и false в противном случае.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */
public class CanPlaceFlowers {
    public boolean canPlace(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) { //проходим по всему массиву и проверяем пусты ли соседние участки
            if (flowerbed[i] == 0 &&                        // проверяем пуста ли наша текущая ячейка
                    (i == 0 || flowerbed[i - 1] == 0) &&    // пуста ли ячейка слева и существует ли она
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) { // пуста ли ячейка справа и существует ли она
                flowerbed[i] = 1;
                count++;
                if (count >= n) {
                    return true;
                }
            }
        }
        return count >= n; // проверка, если count больше или равен n, тогда вернётся true

    }


    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
//        int[] flowerbed = {1, 0, 0, 0, 1};
//        int n = 1;
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        boolean result = cpf.canPlace(flowerbed, n);
        System.out.println(result);
    }

}
