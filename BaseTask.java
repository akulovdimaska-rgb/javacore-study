import java.util.Scanner;

/**
 * Введи с клавиатуры число.
 * Если чётное, напиши "Число чётное"
 * Если число нечётное, напиши "Число нечётное"
 */

public class BaseTask {
    private static final String EVEN = "чётное";
    private static final String ODD = "нечётное";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BaseTask baseTask = new BaseTask();

        while (scanner.hasNextLine()) {
            System.out.println("Введите любое число");
            int number = Integer.parseInt(scanner.nextLine());
            String result = baseTask.isEven(number);
            System.out.printf("Введённое число %d - %s%n", number, result);
        }
    }

    public String isEven(int number) {

        return (number % 2 == 0) ? EVEN:ODD;
    }
}
