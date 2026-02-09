package Home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//0 1 10 11 100 101 110 111 1000 1001 1010
public class ConvertToBinary {
    public static void main(String[] args) {
        long decimal = 5000000000L;

        ConvertToBinary convertToBinary = new ConvertToBinary();
        System.out.println(convertToBinary.convertToBinary(decimal));
        System.out.println("-------------");
        System.out.println(Long.toBinaryString(decimal));

    }

    public String convertToBinary(long decimal) {
        StringBuilder binary = new StringBuilder();

        while (decimal != 0) {
            long remains = decimal % 2;
            decimal = decimal >> 1;
            // или так decimal /= 2;
            binary.insert(0, remains);
        }

        return binary.toString();
    }

}
