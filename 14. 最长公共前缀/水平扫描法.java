class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.isEmpty()) {
                return "";
            }
        }
        return prefix;
    }

    private String getPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int index = 0;
        while (index < len && a.charAt(index) == b.charAt(index)) {
            ++index;
        }
        return a.substring(0, index);
    }
}
