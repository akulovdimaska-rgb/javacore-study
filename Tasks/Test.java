package Tasks;// My first program

import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();

        String result = path.replace('/', '\\');

        System.out.println(result);
    }
}