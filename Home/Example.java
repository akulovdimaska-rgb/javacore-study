package Home;

import java.util.HashMap;
import java.util.Map;
//Находим первое уникальное число в массиве
public class Example {

    public int searchUniqueValue(int[] array) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map1.containsKey(array[i])) {           // если map1 содержит ключ (число из массива)
                int currentValue=map1.get(array[i])+1;  // тогда текущему значению прибавляем 1
                map1.put(array[i],currentValue);        // Значение HashMap (Ключ (i-тый элемент массива, текущее значение)
            } else {
                map1.put(array[i], 1);                  // Иначе i-тый элемент кладется со значением 1
            }
        }                                               // После того как HashMap заполнен
        for (int i=0;i<array.length;i++){               // пробегаем по массиву
            if (map1.get(array[i])==1){                 // и сравниваем значение Value с 1-цей, если true,
                return array[i];                        // то возвращаем i-тый элемент, который встречается один раз
            }

        }
        return -1;                                      // если уникальный элемент не найден, то возвращаем -1

    }

}
//9,4,9,2,5,6
class   ExampleTest{
    public static void main(String[] args) {
        Example example = new Example();
        //System.out.println(example.searchUniqueValue(new int[]{9,4,9,4,5,5}));
        System.out.println(example.searchUniqueValue(new int[]{9,4,9,2,5,6}));
    }
}
