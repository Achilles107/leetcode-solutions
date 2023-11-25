package graphs;

public class MaximizeDistancetoClosestPerson {

    private int[] onlyOnePerson(int[] seats, int n) {
        int left = 0;
        int right = n - 1;
        boolean foundLeft = false;
        boolean foundRight = false;
        while (left <= right) {
            if (seats[left] != 1) {
                left++;
            } else {
                foundLeft = true;
            }
            if (seats[right] != 1) {
                right--;
            } else {
                foundRight = true;
            }
            if (foundLeft && foundRight)
                break;
        }
        return new int[]{left, right};
    }

    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int dist[] = onlyOnePerson(seats, n);
        int firstOne = dist[0];
        int lastOne = dist[1];
        int maxDist = Math.max(firstOne, (n - 1) - lastOne);
        if (firstOne == lastOne) {
            return maxDist;
        }
        if (firstOne > lastOne)
            return n;
        // Find the no of zeros between two 1s
        int zeroesBetween = 0;
        int j = firstOne;
        int idx = 0;
        while (j <= lastOne) {
            if (seats[j] == 1) {
                if (zeroesBetween % 2 == 0) {
                    maxDist = Math.max(maxDist, zeroesBetween / 2);
                } else {
                    maxDist = Math.max(maxDist, zeroesBetween / 2 + 1);
                }
                firstOne = j;
                zeroesBetween = 0;
            } else {
                zeroesBetween++;
            }
            j++;
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int seats[] = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(new MaximizeDistancetoClosestPerson().maxDistToClosest(seats));
    }
}
