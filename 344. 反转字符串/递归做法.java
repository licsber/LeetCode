class Solution {
    public void reverseString(char[] s) {
        reverseStringR(s, 0, s.length - 1);
    }

    private void reverseStringR(char[] s, int left, int right) {
        if (left < right) { // 相等的话会多一次无用的交换
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            reverseStringR(s, left + 1, right - 1);
        }
    }
}
