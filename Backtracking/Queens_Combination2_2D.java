
// Queens Combination in 2D matrix

class Queens_Combination2_2D {

    static int count = 0;

    public static void solve(char matrix [][]){

        int itemNo = 1;
        int totalQueens = matrix.length;
        int totalBoxes = matrix.length*matrix[0].length;
        int lastupdate = -1;
        combination(itemNo, totalQueens, totalBoxes, lastupdate, matrix);
        System.out.println(count);
        
    }

    // Boxes as option
    public static void combination(int itemNo, int totalQueens, int totalBoxes, int lastupdate, char matrix[][]){

        // Base Condition
        if(itemNo>totalQueens){
            count++;
            display(matrix);
            return;

        }

        for(int i=lastupdate+1; i<totalBoxes; i++){

        int row = i/matrix[0].length;
        int col = i%matrix[0].length;

        if(matrix[row][col]=='\u0000'){
            matrix[row][col] = 'Q';
            lastupdate = i;
            combination(itemNo+1, totalQueens, totalBoxes, lastupdate, matrix);
            matrix[row][col] = '\u0000'; // While returning undo the changes  
        }
      }
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
