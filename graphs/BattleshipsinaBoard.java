package graphs;

public class BattleshipsinaBoard {
    public int countBattleships(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        int noOfShips = 0;
        for (int row =0; row<rowSize; row++) {
            for (int col=0; col<colSize; col++) {
                if (board[row][col] == 'X') {
                    findShips(row, col, board, rowSize, colSize);
                    noOfShips++;
                }
            }
        }
        return noOfShips;
    }
    private boolean canMove(int row, int col, int rowSize, int colSize) {
        return (row >=0 && row < rowSize) && (col >=0 && col < colSize);
    }

    private void findShips(int row, int col, char[][] board, int rowSize, int colSize) {
        if (!canMove(row, col, rowSize, colSize) || board[row][col] == '.'){
            return;
        }
        board[row][col] = '.';
        findShips(row, col+1, board,rowSize, colSize);
        findShips(row, col-1, board,rowSize, colSize);
        findShips(row+1, col, board,rowSize, colSize);
        findShips(row-1, col, board,rowSize, colSize);
    }
    public static void main(String[] args) {

    }
}
