import java.util.Arrays;

public class N_Queens {
    static boolean isSafe(int row, int column, char[][] board){
        
        // checking in same row
        for(int j=0; j<board.length; j++){
            if(j!=column && board[row][j]=='Q') return false;
        }

        // checking in same column
        for(int i=0; i<board.length; i++){
            if(i!=row  && board[i][column]=='Q') return false;
        }

        // checking in upper left
        for(int r=row, c=column; c>=0 && r>=0; c--, r--){
            if(board[r][c]=='Q') return false;
        }

        // checking in upper right
        for(int r=row, c=column; c<board.length && r>=0; c++, r--){
            if(board[r][c]=='Q') return false;
        }

        // checking in lower left
        for(int r=row, c=column; c>=0 && r<board.length; c--, r++){
            if(board[r][c]=='Q') return false;
        }        

        // checking in lower right
        for(int r=row, c=column; c<board.length && r<board.length; r++, c++){
            if(board[r][c]=='Q') return false;
        }

        return true;
    }

    static int count=0;
    static void solveNQueens(char[][] board, int column){
        if(column==board.length){
            System.out.println(count++);
            for(char[] row : board) {
                for(char ch : row){
                    if(ch=='Q') System.out.print("Q ");
                    else System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int row=0; row<board.length; row++){
            if(isSafe(row, column, board)){
                board[row][column] = 'Q';
                solveNQueens(board, column+1);
                board[row][column] = '.';
            }
        }
    }
    public static void main(String[] args) {
        solveNQueens(new char[10][10], 0);
    }
}
