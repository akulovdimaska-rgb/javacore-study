package Home;

import java.util.ArrayList;

public class TestJavaRush {
    public static void main(String[] args) {


        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                list.add(i);
            }
        }
        System.out.println("Исходный список: " + list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        ArrayList<Integer> indexesToRemove = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            if (i % 4 == 0){
                indexesToRemove.add(i);
            }
        }

        for (int i = indexesToRemove.size() - 1; i >= 0; i--){
            int index = indexesToRemove.get(i);
            if (index < list.size()){
                list.remove(index);
            }
        }

        System.out.println("После удаления каждого четвертого: " + list);

        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
        }

        System.out.println("Список после удалений: " + list);
    }
}
