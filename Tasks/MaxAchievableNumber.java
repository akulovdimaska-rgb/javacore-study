package Tasks;

public class MaxAchievableNumber {
    public int max(int num, int t) {
        return num + t + t;
    }

    public static void main(String[] args) {

        MaxAchievableNumber man = new MaxAchievableNumber();
        int num = 4;
        int t = 1;

        int result = man.max(num, t);
        System.out.println(result);

    }

}