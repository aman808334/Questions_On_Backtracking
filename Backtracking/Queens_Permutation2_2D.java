 
 // Queens Permutation in 2D matrix
 
 class Queens_Permutation2_2D {

    static int count = 0;

    public static void solve(String matrix [][]){

        boolean usedItem[] = new boolean [matrix.length+1];
        int boxNumber = 0;
        int totalBox = matrix.length*matrix[0].length;
        int selection = 0;
        queensPermutation(boxNumber, totalBox, selection, usedItem, matrix);
        System.out.println(count);
    }

    // Boxes are on level
    public static void queensPermutation(int boxNumber, int totalBox, int selection, boolean usedItem[], String matrix[][]){

        // Base Condition
        if(boxNumber==totalBox){
            if(selection==matrix.length){
               count++;
               display(matrix);
            }
            return;
        }

        for(int i=1; i<=matrix.length; i++){ // Total Queens = Matrix length 

            int row = boxNumber/matrix[0].length;
            int col = boxNumber%matrix[0].length;

            if(usedItem[i]==false) {
            usedItem[i] = true;
            matrix[row][col] = "Q"+i;
            queensPermutation(boxNumber+1, totalBox, selection+1, usedItem, matrix); // Box is selected 
            usedItem[i] = false;
            matrix[row][col] = null;
            }
        }

        queensPermutation(boxNumber+1, totalBox, selection, usedItem, matrix); // Box isn't Selected
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
