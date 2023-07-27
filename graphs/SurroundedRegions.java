package graphs;

public class SurroundedRegions {
    public void solve(char[][] board) {

        for (int j =0; j<board[0].length; j++){
            dfs(board, 0, j);
        }
        for (int i=0; i<board.length; i++){
            dfs(board, i, 0);
        }
        for (int i=0; i<board.length; i++){
            dfs(board, i, board[0].length-1);
        }
        for (int j=0; j<board[0].length; j++){
            dfs(board, board.length-1, j);
        }

        for (int i =0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean move(int i, int j, char[][] board) {
        if (i>=0 && i<=board.length-1 && j>=0 && j<=board[0].length-1){
            return true;
        }

        return false;
    }
    private void dfs(char[][] board, int i, int j) {
        if (!move(i,j, board))
            return;
        if (move(i, j, board) && board[i][j] != 'O' )
            return;
        if (board[i][j] == '1')
            return;
        if (board[i][j] == 'O')
            board[i][j] = '1';
        dfs(board, i, j-1);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i+1, j);
    }
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solve(board);
        for (int i =0; i<board.length; i++){
            System.out.println();
            for (int j=0; j<board[i].length; j++){
                System.out.print(" " + board[i][j]);
            }
        }
    }
}
