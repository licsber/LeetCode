import java.util.Arrays;

class Solution {
    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        int[] copy = Arrays.copyOf(coins, coins.length);
        memo = new int[amount];
        return dfs(copy, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return amount;
        }
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        return memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
    }
}
