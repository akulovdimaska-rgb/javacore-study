package Tasks;

public class Summa {

    public static void main(String[] args){
        int [] array = {0, 6, 4, 1};
        int summa = 0;
        for (int a:array){
            summa+=a; //способ сложить все элементы массива
        }
        System.out.println(summa);
    }
}
