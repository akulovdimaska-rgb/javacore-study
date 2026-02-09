package Tasks;

import java.util.Arrays;

public class TwoSum {


    /*public Tasks.TwoSum() {
    }*/

    public static int summation(int a, int b) {
        return a+b;
    }

    /*public static void returnTraining() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        return;
        System.out.println("4");
        System.out.println("5");
    }*/

    public static void trr(String[] args) {
        System.out.println("Prng");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }



    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] numbers = {2, 15, 11, 7};
        int target = 9;

        int[] result = sum.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));

    }




}


