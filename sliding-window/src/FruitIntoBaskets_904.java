public class FruitIntoBaskets_904 {
    public static void main(String[] args) {
        int[] fruits = {0, 1, 2, 2};

        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[n + 1];

            for (int j = i; j < n; j++) {
                freq[fruits[j]]++;

                int numFruits = 0;
                for (int k = 0; k < freq.length; k++) {
                    if (freq[k] > 0) {
                        numFruits++;
                    }
                }

                if (numFruits == 2) {
                    maxLen = Math.max(maxLen, (j - i + 1));
                }
            }
        }

        return maxLen;
    }
}
