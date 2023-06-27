package math;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reversed(matrix);
    }

    private void reversed(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i < matrix.length / 2) {
                    //System.out.print(" "+matrix[j][i]);
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImage().rotate(matrix);
        //System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(" " + matrix[i][j]);
            System.out.println();
        }
    }
}
