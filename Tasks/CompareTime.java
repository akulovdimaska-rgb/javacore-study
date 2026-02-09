package Tasks;

public class CompareTime {
    final static int VALUE = 1_000_000_000;

    static void main(String[] args) {
        CompareTime compareTime = new CompareTime();
        long start = System.currentTimeMillis();
        long sum1 = compareTime.time(1, VALUE);
        System.out.println("Время однопоточного метода = " + (System.currentTimeMillis() - start) + " мс " + "Результат " + sum1);
    }

    public long time(int start, int end) {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}



