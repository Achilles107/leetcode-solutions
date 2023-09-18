package stack;

import java.util.Stack;

public class AsteroidCollision {

    private boolean differentDirection(int asteroid, int prevAst) {
        return (asteroid < 0 && prevAst > 0);
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStates = new Stack<>();
        for (int asteroid: asteroids) {
            if (asteroidStates.isEmpty()) {
                asteroidStates.push(asteroid);
                continue;
            }
            while (!asteroidStates.isEmpty() && differentDirection(asteroid, asteroidStates.peek())) {
                int prevAsteroid = asteroidStates.pop();
                if (Math.abs(prevAsteroid) > Math.abs(asteroid)) {
                    asteroid = prevAsteroid;
                } else if (Math.abs(prevAsteroid) == Math.abs(asteroid)) {
                    asteroid = 1001;
                    break;
                }
            }
            if (asteroid != 1001)
                asteroidStates.add(asteroid);
        }
        int size = asteroidStates.size();
        int[] result = new int[size];
        while (size > 0) {
            size--;
            result[size] = asteroidStates.pop();
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
