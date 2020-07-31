class Solution {
    public int findMagicIndex(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                return i;
            }
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }
}
