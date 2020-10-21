class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int lena = name.length();
        int lenb = typed.length();
        int i = 0, j = 0, num = 0;
        char last = name.charAt(0);
        while (i < lena && j < lenb) {
            char a = name.charAt(i);
            char b = typed.charAt(j);
            while (a == last) {
                ++num;
                if (++i >= lena) {
                    break;
                }
                a = name.charAt(i);
            }
            while (b == last) {
                --num;
                if (++j >= lenb) {
                    break;
                }
                b = typed.charAt(j);
            }
            if (num > 0) {
                return false;
            }
            num = 0;
            last = a;
        }
        return i == lena && j == lenb;
    }
}
