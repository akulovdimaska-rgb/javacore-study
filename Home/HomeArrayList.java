package Home;

import java.util.Arrays;
import java.util.Objects;

public class HomeArrayList<T> {
    private Object[] array;
    private int counter;
    private static final int INITIAL_CAPACITY = 2;

    public HomeArrayList() {
        this.array = new Object[INITIAL_CAPACITY];
    }

    boolean add(T value) {
        if (counter == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
            array[counter] = value;
            counter++;
            return true;
        } else {
            array[counter] = value;
            counter++;
        }
        return true;
    }

    boolean remove(T value) {
        boolean r = false;
        for (int i = 0; i < array.length - 1; i++) {
            //1,2|4|,5,8,7
            System.out.println("Начало цикла " + array[i]);
            if (array[i] == value) {
                r = true;
            }
            if (r) {
                array[i] = array[i + 1];
                System.out.println("Изменили значение i-го элемента " + array[i]);
            }
            System.out.println("Конец итерации, array[i]= " + array[i]);
        }
        if (!r) {
            return r;
        } else {
            counter--;
            System.out.println("Размер массива: " + counter);
            array = Arrays.copyOf(array, array.length - 1);
            System.out.println("Размер массива: " + counter);
        }
        return true;

    }

    int size() {
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object el : array) {
            if (Objects.nonNull(el))
                sb.append(el).append(", ");
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.append("]").toString();
    }

}

class TestArraylist {
    static void main(String[] args) {
        HomeArrayList<Integer> list = new HomeArrayList<Integer>();
        System.out.println(list.add(1));
        System.out.println(list.add(2));
        System.out.println(list.add(3));
        System.out.println(list.add(4));
        System.out.println(list.add(5));
        System.out.println(list.remove(3));
        System.out.println(list);
//        System.out.println(list.size());
    }
}