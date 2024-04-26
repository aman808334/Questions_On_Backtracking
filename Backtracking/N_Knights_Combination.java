
// N Knights Combination

// Place 'n' similar knights in a n*n chessboard such that no knights can kill each other 


class N_Knights_Combination {

    static int count = 0;

    public static void solve(char chessboard[][], int totalKnights){

        int boxNo = 0;
        int totalBox = chessboard.length*chessboard[0].length;
        int selection = 0;
        knightsCombination(boxNo, totalBox, totalKnights, selection, chessboard);
        System.out.println(count);


    }

    // Boxes on level & each box will have 2 options
    public static void knightsCombination(int boxNo, int totalBox, int totalKnights, int selection, char chessboard[][]){

        // Base Condition
        if(boxNo==totalBox){
            if(selection==totalKnights){
                count++;
                display(chessboard);
            }  
           return;
        }

        int row = boxNo/chessboard[0].length;
        int col = boxNo%chessboard[0].length;


        if(isPlaceSafe(chessboard, row, col)){

            chessboard[row][col] = 'k';
            knightsCombination(boxNo+1, totalBox, totalKnights, selection+1, chessboard); // Selected
            chessboard[row][col] = '\u0000'; // While returning undo the changes
        }

        knightsCombination(boxNo+1, totalBox, totalKnights, selection, chessboard); // Not Selected
    }

    // Knight has total 8 moves from a point but we'll only 4 in this case
    public static boolean isPlaceSafe(char chessboard[][], int row, int col){ 

    if(row-2>=0 && col-1>=0 && chessboard[row-2][col-1] =='k'){
       return false;
    }

    if(row-2>=0 && col+1<chessboard[0].length && chessboard[row-2][col+1] =='k'){
       return false;
    }

    if(row-1>=0 && col-2>=0 && chessboard[row-1][col-2] =='k'){
       return false;
    }

    if(row-1>=0 && col+2<chessboard[0].length && chessboard[row-1][col+2] =='k'){
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
        int totalKnights = 4;
        solve(chessboard, totalKnights);
    }
    
}
