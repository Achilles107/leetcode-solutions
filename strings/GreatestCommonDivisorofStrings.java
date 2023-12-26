package strings;

public class GreatestCommonDivisorofStrings {

    private int gcd(int len1, int len2) {
        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;
        return gcd(len2, len2 % len1);
    }
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int gcd = gcd(len1, len2);
        return str2.substring(0, gcd);
    }
    public static void main(String[] args) {

    }
}
