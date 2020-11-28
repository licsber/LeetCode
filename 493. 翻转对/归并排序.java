class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        return merge(nums, 0, nums.length - 1, tmp);
    }

    private int merge(int[] nums, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int n1 = merge(nums, left, mid, tmp);
        int n2 = merge(nums, mid + 1, right, tmp);
        int res = n1 + n2;

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] - nums[j] > nums[j]) {
                ++j;
            }
            res += j - mid - 1;
        }

        System.arraycopy(nums, left, tmp, left, right - left + 1);
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1) {
                nums[i] = tmp[r++];
            } else if (r == right + 1) {
                nums[i] = tmp[l++];
            } else if (tmp[l] <= tmp[r]) {
                nums[i] = tmp[l++];
            } else {
                nums[i] = tmp[r++];
            }
        }

        return res;
    }
}
