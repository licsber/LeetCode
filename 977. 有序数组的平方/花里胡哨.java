import java.util.stream.IntStream;

class Solution {
    public int[] sortedSquares(int[] A) {
        return IntStream.of(A).map(i -> i * i).sorted().toArray();
    }
}
