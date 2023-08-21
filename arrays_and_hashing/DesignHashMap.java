package arrays_and_hashing;

class MyHashMap {

    private boolean[] isPresent;
    private int[] hashmap;
    private final int MAX_SIZE = 1000000+1;
    public MyHashMap() {
        this.isPresent = new boolean[this.MAX_SIZE];
        this.hashmap = new int[this.MAX_SIZE];
    }

    public void put(int key, int value) {
        this.isPresent[key] = true;
        this.hashmap[key] = value;
    }

    public int get(int key) {
        if (isPresent[key])
            return this.hashmap[key];
        return -1;
    }

    public void remove(int key) {
        this.isPresent[key] = false;
    }
}
public class DesignHashMap {
    public static void main(String[] args) {

    }
}
