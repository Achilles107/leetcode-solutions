package graphs;

//19:26

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpstoReachHome {

    class Jump {
        public int value;
        public boolean canJump;

        public Jump(int value, boolean canJump) {
            this.value = value;
            this.canJump = canJump;
        }

    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Jump> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for (int forbid : forbidden) {
            seen.add(forbid);
        }
        if (seen.contains(0))
            return -1;
        if (x == 0) {
            return 0;
        }
        queue.add(new Jump(0, true));
        seen.add(0);

        int noOfJumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Jump currJump = queue.poll();
                int forward = currJump.value + a;
                int backward = currJump.value - b;
                if (currJump.value == x)
                    return noOfJumps;

                if (backward > 0 && currJump.canJump && !seen.contains(backward)) {
                    queue.add(new Jump(backward, false));
                    seen.add(backward);
                }

                if (forward < (2000 + 2 * b + 1) && !seen.contains(forward)) {
                    queue.add(new Jump(forward, true));
                    seen.add(forward);
                }

            }
            noOfJumps++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
