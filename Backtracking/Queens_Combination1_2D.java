
// Queens Combination in 2D matrix

class Queens_Combination1_2D {

    static int count = 0;

    public static void solve(char matrix [][]){

        int boxNumber = 0;
        int totalBox = matrix.length*matrix[0].length;
        int selection = 0;
        int totalQueens = matrix.length;
        combination(boxNumber, totalBox, selection, totalQueens, matrix);
        System.out.println(count);
    }

    // Boxes on level - Each boxes has 2 option to be selected & not to be
    public static void combination(int boxNumber, int totalBox, int selection, int totalQueens, char matrix[][]){

        // Base Condition
        if(boxNumber==totalBox){
            if(selection==totalQueens){
                count++;
                display(matrix);
            }
          return;
        }

        int row = boxNumber/matrix[0].length;
        int col = boxNumber%matrix[0].length;

        matrix[row][col] = 'Q';
        combination(boxNumber+1, totalBox, selection+1, totalQueens, matrix); // Selected Call
        matrix[row][col] = '\u0000'; // While returning undo the change
 
        combination(boxNumber+1, totalBox, selection, totalQueens, matrix); // Not Selected call
 
    }

    public static void display(char matrix[][]){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();    
        }
          System.out.println("------------------------------------------------"); 
          System.out.println(); 
    }

    public static void main(String[] args) {
        char matrix [][] = new char[4][4];
        solve(matrix);
        
    }  
}
