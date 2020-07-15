import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>();
        int index = 0;
        for (int i : nums1) {
            if (index >= nums2.length) {
                break;
            }
            if (i == nums2[index]) {
                tmp.add(i);
                ++index;
            } else if (i > nums2[index]) {
                do {
                    ++index;
                } while (index < nums2.length && i > nums2[index]);
                if (index < nums2.length && i == nums2[index]) {
                    tmp.add(i);
                    ++index;
                }
            }
        }
        return tmp.stream().mapToInt(i -> i).toArray();
    }
}
