import java.util.Arrays;

class Solution {

    public int countPrimes(int n) {
        int[] primes = preparePrime(n + 1);

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ++res;
            }
        }
        return res;
    }

    private int[] preparePrime(int num) {
        if (num <= 1) {
            return new int[]{0, 0};
        }

        int[] res = new int[num];
        Arrays.fill(res, 1);

        res[0] = res[1] = 0;
        for (int i = 2; i < res.length; i++) {
            if (res[i] == 1 && i * i < res.length) {
                for (int j = 2; i * j < res.length; j++) {
                    res[i * j] = 0;
                }
            }
        }
        return res;
    }
}
