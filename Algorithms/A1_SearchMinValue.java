package Algorithms;

public class A1_SearchMinValue {

    public static void main(String[] args) {
        int[] array = new int[]{41, 32, 64, 12, 28, 62, 55, 18, 71, 36, 49};

        int minValue = array[0];
        int minIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue){
                minValue = array[i];
                minIndex = i;
            }
        }
        System.out.println("min value: " + minValue);
        System.out.println("min index: " + minIndex);
    }
}