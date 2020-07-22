import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int loc = Arrays.binarySearch(numbers, i + 1, numbers.length, target - num);
            if (loc > 0) {
                return new int[]{i + 1, loc + 1};
            }
        }
        return null;
    }
}
