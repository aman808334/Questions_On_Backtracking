
// Gold in the Island. Collect maximum gold

/*
 You are given a matrix, each block of that matrix contains a +ve number.
 If it contains '0' that means it is a water body & you can't go to that block.
 If it contains a non zero number then it means that block has that much kg of gold.
 U have to visit all island & collect gold & return the maximum gold which u can collect from
 a particular island

 Rules -
 
(1) U can't go to water bodies i.e block with '0'.
(2) U can't visit the same block twice.
(3) U can start from any point in search of maximum gold
(4) U can go to all four directions

 Sample Input -

 0 1 4 2 8 2
 4 3 6 5 0 4
 1 2 4 1 4 6
 2 0 7 3 2 2
 3 1 5 9 2 4
 2 7 0 8 5 1

 Sample Output - 
  
 120 

 */

class Gold_In_Islands {
    
    static int maxGold = 0;
    static int sum = 0;

    public static int collectMax(int arr[][]){

        boolean visited[][] = new boolean[arr.length][arr[0].length];

        // We can start from any point. So, I'll give chance to every point to be start point
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){  

                if(arr[i][j] != 0 && visited[i][j] != true){
                    collect(arr, i, j, visited); 
                    maxGold = Math.max(maxGold, sum); // A/f the call, So, at returning time.
                    sum = 0;
                }
            }
        }
        
       return maxGold;
    }
    
    public static void collect(int arr[][], int row, int col, boolean visited[][]) {

        // Base Condition
        if(row<0 || col<0 || row==arr.length || col==arr[0].length || arr[row][col]==0 || visited[row][col]==true){
            return;
        }

                    visited[row][col] = true;
                    sum += arr[row][col];

                    collect(arr, row-1, col, visited); // Top Move
                    collect(arr, row, col+1, visited); // Right Move
                    collect(arr, row+1, col, visited); // Down Move
                    collect(arr, row, col-1, visited); // Left Move
    }

    public static void main(String[] args) {
        int arr [][] = {{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};
        System.out.println(collectMax(arr));
    }
}