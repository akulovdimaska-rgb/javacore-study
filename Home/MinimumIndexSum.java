package Home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 599. Minimum Index Sum of Two Lists
// Даны два массива типа String.
// 1. Необходимо найти общий элемент String
// 2. Вернуть строки с наименьшей суммой индексов
public class MinimumIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap< Integer, List< String >> map = new HashMap < > (); //создали {Хэшмапу ключ i+j, значение - список Строк
        for (int i = 0; i < list1.length; i++) {                    // берём стринг (слово) из массива list1
            for (int j = 0; j < list2.length; j++) {                // и берём стринг из массива list 2
                if (list1[i].equals(list2[j])) {                    // и сравниваем их по equals, если эквивалентны,
                    if (!map.containsKey(i + j))                    // проверяем нет ли такого ключа в мапе и если нет,
                        map.put(i + j, new ArrayList< String >());  // то кладем в Мапу ключ (i+j), а в значение пустой
                                                                    // ArrayList
                    map.get(i + j).add(list1[i]);                   // по ключу и добавляем элемент
                }                                                   // из list1 значение (ArrayList) из list1
            }
        }                                                           // Ищем наименьшую сумму индексов (i + J)
        int min_index_sum = Integer.MAX_VALUE;                      // для этого инициализировали переменную
        for (int key: map.keySet())                                 // с помощью foreach перебираем ключи в Мапе
            min_index_sum = Math.min(min_index_sum, key);           // присваиваем переменной наименьшее значение
        String[] res = new String[map.get(min_index_sum).size()];   // создали массив для хранения минимальных значений
        return map.get(min_index_sum).toArray(res);                 // получаем значение минимального индекса и
    }                                                               // сохраняем в массив res
                                                                    // т.к. значений может быть несколько
    public static void main(String[] args) {
        MinimumIndexSum mis = new MinimumIndexSum();
// Nomber 1:
        String [] list1 = {"Сёгун", "Тапиока Экспресс", "Бургер Кинг", "KFC"};
        String [] list2 = {"Пиатти", "Гриль в Торри Пайнс", "Бургер Кинг", "Сёгун"};
//  Nomber 2:
//        String [] list1 = {"happy","sad","good"};
//        String [] list2 = {"sad","happy","good"};
          //Output: sad и happy - т.к. значения индексов у них равно 1, а у good равно 4.
        String [] result = mis.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(result));
    }

}
