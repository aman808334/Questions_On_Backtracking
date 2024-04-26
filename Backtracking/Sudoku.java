
// Sudoku

/*

You are given a partially filled 9*9 2D array which represents an incomplete sudoku state 
You are required to assign the digits from 1 to 9 to the empty cells following some rules.

Rule 1-> Digits from 1-9 must occur exactly once in each row.
Rule 2-> Digits from 1-9 must occur exactly once in each column.
Rule 3-> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array

Assumption -

The given Sudoku puzzle will have a single unique solution.

Sample Input -

3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1 
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0

Sample Output -

3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

*/

class Sudoku{

    public static void solveSudoku(int arr[][], int r, int c) {  // Initially at (0,0)

        // Base Condition
        if(r==arr.length){
          display(arr);
          return;
        }

        // For iteration in the array
        int nextRow = 0;
        int nextCol = 0;

        if(c==arr[0].length-1){
            nextRow = r+1;
            nextCol = 0;
        }
        else{
            nextRow = r;
            nextCol = c+1;
        }

        

        if(arr[r][c]!=0) {
            solveSudoku(arr, nextRow, nextCol);
        }
        else{
            for(int option=1; option<=9; option++){
                if(canValueBePlaced(arr, r, c, option)==true){
                    arr[r][c] = option; // Put that value in that block
                    solveSudoku(arr, nextRow, nextCol);
                    arr[r][c] = 0; // Undo the changes while coming back.

                }
            }
        }

    }

    public static boolean canValueBePlaced(int arr[][], int row, int col, int value){

        // Row Check - Row will be the same, column will change
        for(int i=0; i<arr[0].length; i++) {
            if(arr[row][i]==value)
              return false;
        }

        // Column Check - Column will be the same, row will change
        for(int i=0; i<arr.length; i++) {
            if(arr[i][col]==value)
              return false;
        }

        // Matrix Check
        int i = 3*(row/3); // Getting matrix top left row
        int j = 3*(col/3); // Getting matrix top left column
        for(int ii=0; ii<3; ii++) {
            for(int jj=0; jj<3; jj++) {
                if(arr[i+ii][j+jj]==value)
                  return false;
            }
        }
        return true;
    }

    public static void display(int arr[][]) {

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{3,0,6,5,0,8,4,0,0},
                       {5,2,0,0,0,0,0,0,0},
                       {0,8,7,0,0,0,0,3,1},
                       {0,0,3,0,1,0,0,8,0},
                       {9,0,0,8,6,3,0,0,5},
                       {0,5,0,0,9,0,6,0,0},
                       {1,3,0,0,0,0,2,5,0},
                       {0,0,0,0,0,0,0,7,4},
                       {0,0,5,2,0,6,3,0,0}};

        solveSudoku(arr,0,0); // Initially sr & sc are '0'          
    }
}