class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        String mm = Integer.toBinaryString(m);
        String nn = Integer.toBinaryString(n);
        mm = "0".repeat(Integer.SIZE - mm.length()) + mm;
        nn = "0".repeat(Integer.SIZE - nn.length()) + nn;

        for (int i = 0; i < Integer.SIZE; i++) {
            if (mm.charAt(i) != nn.charAt(i)) {
                String res = mm.substring(0, i) + "0".repeat(Integer.SIZE - i);
                return Integer.parseInt(res, 2);
            }
        }

        return m;
    }
}
