class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int sum = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0 || sum != 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            sum += n1 + n2;
            res.append(sum % 10);
            sum /= 10;
        }

        return res.reverse().toString();
    }
}
