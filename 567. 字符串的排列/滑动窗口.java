import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < len1; i++) {
            ++a1[s1.charAt(i) - 'a'];
            ++a2[s2.charAt(i) - 'a'];
        }

        for (int i = len1; i < len2; i++) {
            if (Arrays.equals(a1, a2)) {
                return true;
            }
            --a2[s2.charAt(i - len1) - 'a'];
            ++a2[s2.charAt(i) - 'a'];
        }
        return Arrays.equals(a1, a2);
    }
}
