
// N Knights Permutation

// Place 'n' different knights in a n*n chessboard such that no knights can kill each other 


class N_Knights_Permutation {

    static int count = 0;

    public static void solve(String chessboard[][], int totalKnights){

        int itemNo = 1;
        int totalBoxes = chessboard.length*chessboard[0].length;
        knightsPermutation(itemNo, totalKnights, totalBoxes, chessboard);
        System.out.println(count);

    }

    // Boxes as option & items(Knights) on level
    public static void knightsPermutation(int itemNo, int totalKnights, int totalBoxes, String chessboard[][]){

        // Base Condition
        if(itemNo>totalKnights){
           count++;
           display(chessboard);
           return;
        }

        for(int i=0; i<totalBoxes; i++){

            int row = i/chessboard[0].length;
            int col = i%chessboard[0].length;

            if(chessboard[row][col]==null && isPlaceSafe(chessboard, row, col)){
                chessboard[row][col] = "K" + itemNo; // Place the Queen
                knightsPermutation(itemNo+1, totalKnights, totalBoxes, chessboard);
                chessboard[row][col] = null; // While returning undo the change
            }
        }
    }

    // Knight has total 8 moves from a point & we'll check all
    public static boolean isPlaceSafe(String chessboard[][], int row, int col){ 

    if(row-2>=0 && col-1>=0 && chessboard[row-2][col-1] != null){
       return false;
    }

    if(row-2>=0 && col+1<chessboard[0].length && chessboard[row-2][col+1] != null){
       return false;
    }

    if(row+2<chessboard.length && col-1>=0 && chessboard[row+2][col-1] != null){
       return false;
    }

    if(row+2<chessboard.length && col+1<chessboard[0].length && chessboard[row+2][col+1] != null){
       return false;
    }

    if(row-1>=0 && col-2>=0 && chessboard[row-1][col-2] != null){
       return false;
    }

    if(row+1<chessboard.length && col-2>=0 && chessboard[row+1][col-2] != null){
       return false;
    }

    if(row-1>=0 && col+2<chessboard[0].length && chessboard[row-1][col+2] != null){
       return false;
    }

    if(row+1<chessboard.length && col+2<chessboard[0].length && chessboard[row+1][col+2] != null){
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
        int totalKnights = 4;
        solve(chessboard, totalKnights);
    }
    
}
