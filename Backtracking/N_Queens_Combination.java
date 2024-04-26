
// N Queens Combination


// Place 'n' similar queens in a n*n chessboard such that no queens can kill each other 


class N_Queens_Combination {

    static int count = 0;

    public static void solve(char chessboard[][], int totalQueens){

        int boxNo = 0;
        int totalbox = chessboard.length*chessboard[0].length;
        int selection = 0;

        queensCombination(boxNo, totalbox, totalQueens, selection, chessboard);
        System.out.println(count);
    }

    // Boxes on level. Each boxes has 2 options
    public static void queensCombination(int boxNo, int totalbox, int totalQueens, int selection, char chessboard[][]){


        // Base Condition
        if(boxNo==totalbox){
            if(selection==totalQueens){
                count++;
                display(chessboard);
            }
            return;
        }

            int row = boxNo/chessboard[0].length;
            int col = boxNo%chessboard[0].length;

            if(isPlaceSafe(chessboard, row, col)){

                chessboard[row][col] = 'Q';
                queensCombination(boxNo+1, totalbox, totalQueens, selection+1, chessboard);
                chessboard[row][col] = '\u0000'; // While returning undo the changes

            }

            queensCombination(boxNo+1, totalbox, totalQueens, selection, chessboard);
        }

    

    public static boolean isPlaceSafe(char chessboard[][], int row, int col){

        // Vertical Check
        for(int i= row, j = col; i>=0; i--){
            if(chessboard[i][j]!='\u0000')
              return false;
        }

        // Left Horizontal Check
        for(int i= row, j = col; j>=0; j--){
            if(chessboard[i][j]!='\u0000')
              return false;
        }

        // Left Diagonal Check
        for(int i= row, j = col; i>=0 && j>=0; i--, j--){
            if(chessboard[i][j]!='\u0000')
              return false;
        }

        // Right Diagonal Check
        for(int i= row, j = col; i>=0 && j<chessboard[0].length; i--, j++){
            if(chessboard[i][j]!='\u0000')
              return false;
        }

        return true;
    }


    public static void display(char chessboard[][]){

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
        
        char chessboard[][] = new char[4][4];
        int totalQueens = 4;
        solve(chessboard, totalQueens);
    }
    
}
