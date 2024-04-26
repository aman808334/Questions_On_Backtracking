
// Path with Max Gold

/*
Rule -

(1) U can't go to the block with '0'.
(2) U can't visit the same block twice.
(3) U can start from any point in search of maximum gold
(4) U can go to all four directions

Example -

Input -> [[0,6,0],
          [5,8,7],
          [0,9,0]]

Output -> 24

Explanation -> Path with max gold = (9-> 8-> 7)
*/

class Path_With_Max_Gold {

    static int max = 0;

    public static int getMaximumGold(int[][] grid) {

        boolean visited[][] = new boolean[grid.length][grid[0].length];

        // Every cell can be the starting point. So FC inside the loop
        for(int row = 0; row<grid.length; row++){
            for(int col = 0; col<grid[0].length; col++){
                if(grid[row][col] != 0){
                  helper(grid,visited,row,col,0);
                }
            }
        }
       return max; 
    }

    public static void helper(int grid[][], boolean visited[][], int row,int col,int sum){

        // Base Condidtion
        if(row >= grid.length || row < 0 || col >= grid[0].length ||  col < 0 ||  grid[row][col] == 0 || visited[row][col] == true){
            max = Math.max(max,sum);
            return;
        }

        visited[row][col] = true;

        // Four Options
        helper(grid, visited, row+1, col, sum+grid[row][col]); // Down Move
        helper(grid, visited, row-1, col, sum+grid[row][col]); // Top Move
        helper(grid, visited, row, col+1, sum+grid[row][col]); // Right Move
        helper(grid, visited, row, col-1, sum+grid[row][col]); // Left Move

        visited[row][col] = false; // While returning undo the changes
    }

    public static void main(String[] args) {
        int arr[][] = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(arr));
    }
}