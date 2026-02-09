package Tasks;

public class Varargs {

    static void summa(String s, int ... a){// ... - это varargs, (int ... a - массив типа int)
        int summa = 0;
        for (int i = 0; i < a.length; i++){
            summa +=a[i]; // так мы можем вывести сумму элементов массива
        }
        System.out.println(summa);
        System.out.println(s);
    }
    public static void main(String[] args){
        summa("ok",3,6,10);
    }
}
