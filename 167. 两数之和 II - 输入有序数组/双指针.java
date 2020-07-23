import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }

        int loc = Arrays.binarySearch(numbers, target);
        if (loc < 0) {
            loc = -loc + 1;
        }
        loc = Math.min(loc + 1, numbers.length - 1);

        int i = 0;
        int j = loc;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                ++i;
            } else {
                --j;
            }
        }
        return null;
    }
}
