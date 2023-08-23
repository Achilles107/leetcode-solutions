package arrays_and_hashing;

public class SignoftheProductofanArray {

    public int arraySign(int[] nums) {
        int noOfNegatives = 0;
        for (int num: nums) {
            if (num < 0)
                noOfNegatives++;
            if (num == 0)
                return 0;
        }
        return noOfNegatives % 2 == 0 ? 1 : -1;
    }
    public static void main(String[] args) {

    }
}
