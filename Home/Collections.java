package Home;

import Lambda.Student;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    //поля
    String s;
    int i;
    String d = new String();

    //классы и конструкторы
    public static void main(String[] args) {
//        public,
//        protected,
//        default,
//        private,

        int a = 1;
        String s = "df";
        String b = "df";
        String n = new String("df").intern();

        A aa = new A();

        List<A> list = List.of(aa, aa, aa);
        list.toArray();
        A[] array = new A[3];


        System.out.println(Arrays.toString(list.toArray(array)));

        System.out.println("=================");
        System.out.println(array instanceof Object);
        System.out.println("=================");

        aa.chislo = 2;
        System.out.println(list);

    }



}

class A {
    int chislo;
    String fg;

    A() {
        this.chislo = 1;
        this.fg = "Hello!";
    }

// Значение первого параметра 1. Значение второго параметра Hello!
    @Override
    public String toString() {

       // return chislo + "";

       // return String.valueOf(chislo);

        return "A{" +
                "Значение первого параметра: " + chislo +
                ", Значение второго параметра: " + fg +
                '}';
    }


}
