package Tasks;

import java.util.ArrayList;
import java.util.List;

public class Clients {
    int adf = 101;
    public List<String> client(String [] array){

        String c = "client: ";
        int n = array.length;
        List<String> list = new ArrayList<>();
        adf = 1;

        for (int i = 0; i < n; i++) {
            list.add(c + array[i]);

        }
        return list;
    }



    public static void main (String[] args) {
        String [] array = {"Ivanov", "Petrov"};
        Clients cl = new Clients();

        System.out.println(cl.client (array));

    }

}
