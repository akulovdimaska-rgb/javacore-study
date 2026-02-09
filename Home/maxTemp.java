package Home;

public class maxTemp {
    public static void main(String[] args) {
        int[] tempApr2024 = {-1, 3, 4, 9, 5, -2};
        int[] tempApr2025 = {8, 6, 4, 15, 9, 5};

        System.out.println(getMaxDifference(tempApr2024, tempApr2025));
    }

    public static int getMaxDifference(int[] tempApr2024, int[] tempApr2025) {

        int maxDifference = 0;
        for (int i = 0; i < tempApr2024.length; i++) {
        int curentDiffertnce = Math.abs(tempApr2024[i] - tempApr2025[i]);

            if (curentDiffertnce > maxDifference) {
                maxDifference = curentDiffertnce;
            }
        }
        return maxDifference;

    }

}
