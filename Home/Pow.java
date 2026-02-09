package Home;

public class Pow {

    public static void main(String[] args) {
        int value = 3;
        int powValue = 5;
        System.out.println(pow(value, powValue));
    }

    public static int pow(int value, int powValue) {

        if (powValue == 1) {
            return value;
        } else {
            return value * pow(value, powValue - 1);
        }
    }

}
