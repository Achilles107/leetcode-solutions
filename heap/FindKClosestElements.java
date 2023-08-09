package heap;

import java.util.*;

class CustomComparator implements Comparator<Integer> {
    private int x;

    public CustomComparator(int x) {
        this.x = x;
    }

    @Override
    public int compare(Integer a, Integer b) {
        int absDiffA = Math.abs(a - x);
        int absDiffB = Math.abs(b - x);

        if (absDiffA < absDiffB) {
            return 1;
        } else if (absDiffA > absDiffB) {
            return -1;
        } else {
            return Integer.compare(b, a);
        }
    }
}
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> kClosest = new ArrayList<>();
        if (k == arr.length){
            for (int number: arr) {
                kClosest.add(number);
            }
            return kClosest;
        }
        PriorityQueue<Integer> largestFirst = new PriorityQueue<>(new CustomComparator(x));
        for (int number: arr) {
            largestFirst.add(number);
            if (largestFirst.size() > k) {
                largestFirst.poll();
            }
        }

        while (!largestFirst.isEmpty()) {
            kClosest.add(largestFirst.poll());
        }
        kClosest.sort(Comparator.naturalOrder());
        return kClosest;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        System.out.println(new FindKClosestElements().findClosestElements(arr, k, x));
    }
}
