package Home;

import java.util.Arrays;

// данн массив чисел.
//Вывод: [4,0,1,1,3]
public class CountNums {
    public static void main(String[] args) {

        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(CountNums(nums)));
    }

    public static int[] CountNums(int[] nums) {

        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int countNums = 0;


            for (int j = 0; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    countNums++;

                }

            }
            count[i] = countNums; // {4, 0, 1, 1, 3}
        }
        return count;
    }


}
