// Knight Tour.

/*
 A chessboard & starting point is given. If knight moves in such a way that it visit all the blocks
without visiting a block twice, then it is an answer. We've to find all such answer.
 */
class Knight_Tour {
    
    public static void knight(int chessboard[][], int sr, int sc, int move) {

        // Base Condition
        if(move == chessboard.length*chessboard[0].length+1) {
            display(chessboard);
            return;
        }

        else if(sr<0 || sc<0 || sr>=chessboard.length || sc>=chessboard[0].length || chessboard[sr][sc]>0 ){
            return;
        }

        chessboard[sr][sc] = move;

        // knight can move in eight place from a point. So 8 function call
        knight(chessboard, sr-2, sc+1, move+1);
        knight(chessboard, sr-1, sc+2, move+1);
        knight(chessboard, sr+1, sc+2, move+1);
        knight(chessboard, sr+2, sc+1, move+1);
        knight(chessboard, sr+2, sc-1, move+1);
        knight(chessboard, sr+1, sc-2, move+1);
        knight(chessboard, sr-1, sc-2, move+1);
        knight(chessboard, sr-2, sc-1, move+1);

        chessboard[sr][sc] = 0; // While returning fill 0 in block so that new path can be found.
    }

    public static void display(int chessboard[][]) {
        for(int i=0; i<chessboard.length; i++) {
            for(int j=0; j<chessboard[0].length; j++) {
                System.out.print(chessboard[i][j]+" ");
           }
           System.out.println();
        }
        System.out.println();
    }    

    public static void main(String[] args) {
        int chessboard [][] = new int[5][5];
        int sr = 2;
        int sc = 2;
        int move = 1;
        knight(chessboard, sr, sc, move);
    }
}
