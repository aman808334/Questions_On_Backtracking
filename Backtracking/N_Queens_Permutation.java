
// N Queens Permutation

/*
Place 'n' different queens in a n*n chessboard such that no queens can cut each other 
*/

class N_Queens_Permutation {

    static int count = 0;

    public static void solve(String chessboard[][], int totalQueens){


        int itemNo = 1;
        int totalBoxes = chessboard.length*chessboard[0].length;
        queensPermutation(itemNo, totalQueens, totalBoxes, chessboard);
        System.out.println(count);

    }

    // Boxes as level & items(queens) on level
    public static void queensPermutation(int itemNo, int totalQueens, int totalBoxes, String chessboard[][]){


        // Base Condition
        if(itemNo>totalQueens){
            count ++;
            display(chessboard);
            return;
        }

        for(int i=0; i<totalBoxes; i++){

            int row = i/chessboard[0].length;
            int col = i%chessboard[0].length;

            if(chessboard[row][col] == null && isPlaceSafe(chessboard, row, col)){
                chessboard[row][col] = "Q" + itemNo; // Place the queen
                queensPermutation(itemNo+1, totalQueens, totalBoxes, chessboard);
                chessboard[row][col] = null; // While returning undo the changes.
            }
        }

    }

    public static boolean isPlaceSafe(String chessboard[][], int row, int col){

        // Top Vertical Check
        for(int i= row, j = col; i>=0; i--){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Bottom Vertical Check
        for(int i= row, j = col; i<chessboard.length; i++){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Left Horizontal Check
        for(int i= row, j = col; j>=0; j--){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Right Horizontal Check
        for(int i= row, j = col; j<chessboard[0].length; j++){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Top Left Diagonal Check
        for(int i= row, j = col; i>=0 && j>=0; i--, j--){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Top Right Diagonal Check
        for(int i= row, j = col; i>=0 && j<chessboard[0].length; i--, j++){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Bottom Left Diagonal Check
        for(int i= row, j = col; i<chessboard.length && j>=0; i++, j--){
            if(chessboard[i][j]!= null)
              return false;
        }

        // Bottom Right Diagonal Check
        for(int i= row, j = col; i<chessboard.length && j<chessboard[0].length; i++, j++){
            if(chessboard[i][j]!= null)
              return false;
        }

        return true;
    }

    public static void display(String chessboard[][]){

        for(int i=0; i<chessboard.length; i++){
            for(int j=0; j<chessboard[0].length; j++){
                System.out.print(chessboard[i][j] +" ");
            }
            System.out.println();    
        }
          System.out.println("------------------------------------------------"); 
          System.out.println();   
    }

    public static void main(String[] args) {
        
        String chessboard[][] = new String[4][4];
        int totalQueens = 4;
        solve(chessboard, totalQueens);
    }
    
}
