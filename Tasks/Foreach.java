package Tasks;

public class Foreach {
    public static void main(String[] args) {
        int[] array = {0, 6, 4, 1};
       // for (int i = 0; i < array.length; i++) { - это стандартный луп(петля,повторение, цикл)
        for (int a : array){ // - это foreach loop,
                             // пишем тип массива int - создаем переменную int
                             // затем двоеточие и имя массива (array)
                             // открываем фигурные скобки
          //  System.out.print(array[i] + " ");
        }
        // смысл работы этого лупа - переменная по очереди принимает значения массива
        // он знает когда остановиться
        // JAVA сама переводит это код в traditional loop
    }
}
