
// N Queens

/*
N*N chessboard  & n queens are given. We've to place n queens in chessboard so that no queen can cut
other queens.
*/

class N_Queens_Diagonal_Approach {

    public static void placeQueens(boolean chessboard[][]) {
        boolean column [] = new boolean[chessboard[0].length]; // To represent in which columns queen can't be placed.
        boolean nDiagonal [] = new boolean[chessboard.length+chessboard[0].length-1]; // To represent in which normal diagonal queen can't be placed
        boolean rDiagonal [] = new boolean[chessboard.length+chessboard[0].length-1]; // To represent in which reverse diagonal queen can't be placed
        String answer = ""; // Initially Empty

        queensPlace(chessboard, column, nDiagonal, rDiagonal, answer, 0); // Row is initially 0
    }

    public static void queensPlace(boolean chessboard[][], boolean column[], boolean nDiagonal[], boolean rDiagonal[], String answer, int row) {
        // Base Condition
        if(row==chessboard.length){
            System.out.println(answer);
            return;

        }
        // Now the option is equal to the number of columns. So for loop & function call inside the loop.
        for(int col=0; col<chessboard[0].length; col++){
            if(column[col] == false && nDiagonal[row+col] == false && rDiagonal[row-col+chessboard.length-1] == false) {
                chessboard[row][col] = true; // Place the queen
                // A/f placing the queen update the column, nDiagonal & rDiagonal
                column[col] = true;
                nDiagonal[row+col] = true;
                rDiagonal[row-col+chessboard.length-1] = true;

                queensPlace(chessboard, column, nDiagonal, rDiagonal, answer + row + "-" + col + "  ", row+1); // Function Call

                // While returning i.e backtracking undo the changes
                chessboard[row][col] = false;
                column[col] = false;
                nDiagonal[row+col] = false;
                rDiagonal[row-col+chessboard.length-1] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        boolean chessboard [][] = new boolean[4][4];
        placeQueens(chessboard);
    }
}