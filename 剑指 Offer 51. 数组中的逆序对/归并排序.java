class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        int[] tmp = new int[nums.length];

        return mergeSort(copy, 0, nums.length - 1, tmp);
    }

    private int mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int l = mergeSort(arr, left, mid, tmp);
        int r = mergeSort(arr, mid + 1, right, tmp);

        // 归并排序的优化
        if (arr[mid] <= arr[mid + 1]) {
            return l + r;
        }

        int num = mergeSort(arr, left, mid, right, tmp);
        return l + r + num;
    }

    private int mergeSort(int[] arr, int left, int mid, int right, int[] tmp) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);

        int l = left;
        int r = mid + 1;

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1) {
                arr[i] = tmp[r++];
            } else if (r == right + 1) {
                arr[i] = tmp[l++];
            } else if (tmp[l] <= tmp[r]) {
                arr[i] = tmp[l++];
            } else {
                arr[i] = tmp[r++];
                count += mid - l + 1;
            }
        }
        return count;
    }
}
