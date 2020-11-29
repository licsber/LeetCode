import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] A) {
        int[] nums = Arrays.copyOf(A, A.length);
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; --i) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];
            if (valid(a, b, c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    private boolean valid(int a, int b, int c) {
        return a > c - b;
    }
}
