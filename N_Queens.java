import java.util.Arrays;

public class N_Queens {
    static boolean isSafe(int row, int column, int[] attackedRows, int[] attackedDiag1, int[] attackedDiag2){
        return attackedRows[row]==0 && attackedDiag1[row+column]==0 && attackedDiag2[row-column+attackedRows.length-1]==0;
    }

    static void solveNQueens(char[][] board, int column, int[] attackedRows, int[] attackedDiag1, int[] attackedDiag2){
        if(column==board.length){
            for(char[] row: board) System.out.println(Arrays.toString(row));
            System.out.println();
            return;
        }

        for(int row=0; row<board.length; row++){
            if(isSafe(row, column, attackedRows, attackedDiag1, attackedDiag2)){
                board[row][column] = 'Q';
                attackedRows[row] = attackedDiag1[row+column] = attackedDiag2[row-column+board.length-1] = 1;

                solveNQueens(board, column+1, attackedRows, attackedDiag1, attackedDiag2);

                board[row][column] = '.';
                attackedRows[row] = attackedDiag1[row+column] = attackedDiag2[row-column+board.length-1] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int n = 4;
        solveNQueens(new char[n][n], 0, new int[n], new int[2*n-1], new int[2*n-1]);
    }
}
