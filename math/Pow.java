package math;

import java.util.HashMap;
import java.util.Map;

public class Pow {

    Map<Integer, Double> powers = new HashMap<>();
    public double pow(double x, int n){
        if (n == 0)
            return 1;
        if (x == 0.0)
            return x;
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            return pow(x*x, n/2);
        }
        else{
            return pow(x*x, n/2) * x;
        }
    }
    public double myPow(double x, int n) {
        if (x == 1.0)
            return x;
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        return pow(x, n);
    }
    public static void main(String[] args) {
        System.out.println(new Pow().myPow(2.0000, -2));
    }
}
