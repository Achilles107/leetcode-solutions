package heap;

import java.util.PriorityQueue;

public class SeatReservationManager {
    class SeatManager {

        PriorityQueue<Integer> seatsAvail;
        public SeatManager(int n) {
            this.seatsAvail = new PriorityQueue<>();
            for (int seat = 1; seat<=n; seat++) {
                seatsAvail.add(seat);
            }
        }

        public int reserve() {
            return this.seatsAvail.poll();
        }

        public void unreserve(int seatNumber) {
            this.seatsAvail.add(seatNumber);
        }
    }
    public static void main(String[] args) {

    }
}
