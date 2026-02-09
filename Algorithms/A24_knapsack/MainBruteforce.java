package Algorithms.A24_knapsack;

// Задача о рюкзаке. Динамическое программирование
// https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbTVQekNaOHFRTVZ2YmlHeW5pOWtPdERtdERIZ3xBQ3Jtc0tuY29SVDRvbzdNQXN2OXF4bmF1d2RfSGVxdEMwdUE3Qldyc0JQVDlCNUJES2dXakFpRFY3VGNkRE5GSEZ4eUFsbjAtYVRsV3IxQkpqRXhqQkR2VFVkRDNnYVpEUTJEREd4R3U4ZE55MHQxYnZiYUswYw&q=https%3A%2F%2Fneerc.ifmo.ru%2Fwiki%2Findex.php%3Ftitle%3D%25D0%2597%25D0%25B0%25D0%25B4%25D0%25B0%25D1%2587%25D0%25B0_%25D0%25BE_%25D1%2580%25D1%258E%25D0%25BA%25D0%25B7%25D0%25B0%25D0%25BA%25D0%25B5&v=wcjqBf2qRe0


public class MainBruteforce {
    public static void main(String[] args) {
        int[] weights = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxWeight = 13;

        long count = 2L << weights.length;

        int maxPrice = 0;
        long maxState = 0;

        for (long state = 0; state < count; state++) {
            int price = statePrice(state, prices);
            int weight = stateWeight(state, weights);
            if (weight <= maxWeight) {
                if (maxPrice < price) {
                    maxPrice = price;
                    maxState = state;
                }
            }
        }

        System.out.println("Оптимальное содержимое рюкзака:");
        long poverOfTwo = 1;
        for (int i = 0; i < weights.length; i++) {
            if ((poverOfTwo & maxState) > 0) {
                System.out.println(i + 1);
            }
            poverOfTwo <<= 1;
        }
    }

    private static int stateWeight(long state, int[] weights) {
        long poverOfTwo = 1;
        int weight = 0;
        for (int i = 0; i < weights.length; i++) {
            if ((poverOfTwo & state) != 0) {
                weight += weights[i];
            }
            poverOfTwo <<= 1;
        }
        return weight;
    }

    private static int statePrice(long state, int[] prices) {
        long poverOfTwo = 1;
        int price = 0;
        for (int i = 0; i < prices.length; i++) {
            if ((poverOfTwo & state) != 0) {
                price += prices[i];
            }
            poverOfTwo <<= 1;
        }
        return price;
    }
}