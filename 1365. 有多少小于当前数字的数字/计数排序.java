class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i : nums) {
            ++count[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                res[i] += count[j];
            }
        }
        return res;
    }
}
