package arrays_and_hashing;

class MyHashSet {

    private boolean[] array;
    public MyHashSet() {
        this.array = new boolean[Integer.MAX_VALUE];
    }

    public void add(int key) {
        if (!this.array[key])
            this.array[key] = true;
    }

    public void remove(int key) {
        if (this.array[key])
            this.array[key] = false;
    }

    public boolean contains(int key) {
        return this.array[key];
    }
}
public class DesignHashSet {

    public static void main(String[] args) {

    }
}
