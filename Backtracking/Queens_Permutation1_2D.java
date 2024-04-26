

// Queens Permutation in 2D matrix

class Queens_Permutation1_2D {

    static int count = 0;

     public static void solve(String matrix [][]){

        int iteamNo = 1;
        int totalQueens = matrix.length;
        queensPermutation(iteamNo, totalQueens, matrix);
        System.out.println(count);

     }


    // Boxes are on options & items(queens) are on level
    public static void queensPermutation(int itemNo, int totalQueens, String matrix[][]){

        // Base Condition
        if(itemNo>totalQueens){ // Total Queens = Matrix length 
            count++;
            display(matrix);
            return;
        }

        for(int i=0; i < matrix.length*matrix[0].length; i++){

            int row = i/matrix[0].length; 
            int col = i%matrix[0].length;

            if(matrix[row][col]== null){
            matrix[row][col] = "Q" + itemNo;
            queensPermutation(itemNo+1, totalQueens, matrix);
            matrix[row][col] = null;
            }
        }
    }

    public static void display(String matrix[][]){

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
        String matrix [][] = new String[4][4];
        solve(matrix);   
    }
    
}
