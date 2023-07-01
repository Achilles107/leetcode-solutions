package backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    int N;
    int M;
    private boolean isSafe(char[][] board, int x, int y, char desiredChar) {
        //System.out.println(x+":"+y+":"+desiredChar);
        return x >= 0 && x < M && y >=0 && y < N && board[x][y] == desiredChar;
    }

    private boolean trace(char[][] board, String word, int[][] solution, int indx, int len, int x, int y){
        if (indx == len) {
            return true;
        }

        if (isSafe(board, x, y, word.charAt(indx))) {
            //System.out.println(word.charAt(indx));
            if (solution[x][y] == 1)
                return false;
            solution[x][y] = 1;

            if (trace(board, word, solution, indx+1, len, x+1, y))
                return true;
            if (trace(board, word, solution, indx+1, len, x-1, y))
                return true;
            if (trace(board, word, solution, indx+1, len, x, y+1))
                return true;
            if (trace(board, word, solution, indx+1, len, x, y-1))
                return true;

            solution[x][y] = 0;

            return false;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        this.M = board.length;
        this.N = board[0].length;
        List<int[]> coords = new ArrayList<>();
        for (int i =0; i<M; i++){
            for (int j=0; j<N; j++){
                if (board[i][j] == word.charAt(0)){
                    int arr[] = {i,j};
                    coords.add(arr);
                }
            }
        }
        int sol[][] = new int[M][N];
        for (int arr[]: coords){
            //System.out.println(arr[0] +" : "+ arr[1]);
            if (trace(board, word, sol, 0, word.length(), arr[0], arr[1])) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";

        WordSearch solution = new WordSearch();
        boolean result = solution.exist(board, word);
        System.out.println(result);
    }
}
