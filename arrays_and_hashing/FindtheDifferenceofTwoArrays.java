package arrays_and_hashing;

import java.util.*;

public class FindtheDifferenceofTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        Set<Integer> set1 = new TreeSet<>();
        int max = 0;
        for (int num : nums1) {
            set1.add(num);
            max = Math.max(max, num);
        }

        Set<Integer> set2 = new TreeSet<>();
        for (int num : nums2) {
            set2.add(num);
            max = Math.max(max, num);
        }

        Map<Integer, Boolean> seen = new HashMap<>();
        for (int num : nums1) {
            if (!seen.containsKey(num) && !set2.contains(num)) {
                list.get(0).add(num);
                seen.put(num, true);
            }
        }

        seen.clear();

        for (int num : nums2) {
            if (!seen.containsKey(num) && !set1.contains(num)) {
                list.get(1).add(num);
                seen.put(num, true);
            }
        }

        return list;
    }
    public static void main(String[] args) {

    }
}
