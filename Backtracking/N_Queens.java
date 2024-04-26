
// N Queens

/*
N*N chessboard  & n queens are given. We've to place n queens in chessboard so that no queen can cut
other queens.
*/

class N_Queens {

    public static void placeQueens(int chessboard[][], String answer, int row) { // initially row is 0
        // Base Condition
        if(row==chessboard.length){
            System.out.println(answer);
            return;
        }

        for(int col=0; col<chessboard[0].length; col++) {
            if(isQueenSafe(chessboard, row, col)==true) { // function call
              chessboard[row][col] = 1; // Place the queen
              placeQueens(chessboard, answer+" " +row +"," + col, row+1);
              chessboard[row][col] = 0; // Remove the queen while coming back
            }
        }
    } 
        
        // Defining Function
        public static boolean isQueenSafe(int chessboard[][],int r, int c) {
            // Vertical Check
            for(int i=r-1, j=c; i>=0; i--) {
                if(chessboard[i][j]==1)
                  return false;
            }

            // left Diagonal Check
            for(int i=r-1, j=c-1; i>=0 && j>=0; i--,j--) {
                if(chessboard[i][j]==1)
                  return false;
            }

            // Right Diagonal Check
            for(int i=r-1, j=c+1; i>=0 && j<chessboard[0].length; i--,j++) {
                if(chessboard[i][j]==1)
                  return false;
            }
            return true;
        }
    

    public static void main(String[] args) {
        int chessboard[][] = new int[4][4];
        int startRow = 0;
        placeQueens(chessboard, "", startRow); // answer is empty

    }
    
}
