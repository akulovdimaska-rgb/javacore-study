package Tasks;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample {

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums).anyMatch(element -> !set.add(element));
    }

    public static boolean containsDuplicate3(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .count() != nums.length;
    }
}

class SolutionTest {
    public static void main(String[] args) {
        //Solution solution1 = new Solution();
        int[] array = {1, 8, 2, 3, 5, 4, 6, 7, 9, 10};
        System.out.println(StreamExample.containsDuplicate3(array));
    }
}


