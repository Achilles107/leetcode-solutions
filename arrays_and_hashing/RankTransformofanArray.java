package arrays_and_hashing;

import java.util.TreeMap;

public class RankTransformofanArray {
    public int[] arrayRankTransform(int[] arr) {
        TreeMap<Integer, Integer> indices = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            indices.put(arr[i], 0);
        }
        int idx = 1;
        for (Integer key : indices.keySet()) {
            indices.put(key, idx);
            idx += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = indices.get(arr[i]);
        }
        return arr;
    }
}
