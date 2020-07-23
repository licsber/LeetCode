class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null) {
            return -1;
        }

        int len = numbers.length;
        int left = 0;
        int right = len - 1;

        while (left != right) {
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[left]) {
                left = mid;
            } else {
                ++left;
            }
        }
        return numbers[left];
    }
}
