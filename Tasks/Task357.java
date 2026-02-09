package Tasks;

public class Task357 {



        public static void main(String[] args) {
            taskForCondition();
        }

        public static void taskForCondition() {
            int number = 15;
            boolean firstCondition = number < 15 & number > 25 & (number += 15) < 25;
            boolean secondCondition = (number | 5) > 12 || (number = number + 2) > 40;
            System.out.println(Integer.toBinaryString(number));
            System.out.println(Integer.toBinaryString(~number));
        }
    }


