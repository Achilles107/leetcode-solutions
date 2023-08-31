package heap;

import java.util.PriorityQueue;

public class FindtheKthLargestIntegerintheArray {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> smallestFirst = new PriorityQueue<>((a,b) ->{
           int sizeA = a.length();
           int sizeB = b.length();

           if (sizeA != sizeB) {
               return Integer.compare(sizeA,sizeB);
           }

           return a.compareTo(b);
        });

        for (String num: nums) {
            smallestFirst.add(num);

            if (smallestFirst.size() > k) {
                smallestFirst.poll();
            }
        }
        return smallestFirst.peek();
    }
    public static void main(String[] args) {

    }
}
