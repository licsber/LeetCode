import java.util.Arrays;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            for (int j = i; j > index; --j) {
                swap(people, j - 1, j);
            }
        }
        return people;
    }

    private void swap(int[][] people, int i, int j) {
        int[] tmp = people[i];
        people[i] = people[j];
        people[j] = tmp;
    }
}
