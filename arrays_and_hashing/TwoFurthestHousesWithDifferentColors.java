package arrays_and_hashing;

public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int i = 0;
        int len = colors.length;
        int j = len - 1;
        int dist = 0;
        while (i < j) {
            if (colors[i] != colors[j]) {
                dist = j - i;
                break;
            }
            j--;
        }
        j = len - 1;
        int sdist = 0;
        while (i < j) {
            if (colors[i] != colors[j]) {
                sdist = j - i;
                break;
            }
            i++;
        }

        return Math.max(dist, sdist);
    }
}
