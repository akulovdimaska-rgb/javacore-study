package Home;

public class Task1705 {
    public static void main(String[] args) {
        int[] digit = {1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;
        System.out.println(checkMinDistance(digit, k));
    }

    public static boolean checkMinDistance(int[] digit, int k) {
        int firstIndex = 0;
        for (int i = 1; i < digit.length; i++) {

            if (digit[i] == 1) {
                int distance = (i - 1) - firstIndex;
                if (distance < k) {
                    return false;
                }
                firstIndex = i;
            }
        }
        return true;
    }

}
