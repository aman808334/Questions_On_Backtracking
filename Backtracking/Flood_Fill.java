
// Flood Fill

/*
 U r given a 2D array & it is filled with 0 & 1. U are standing in (0,0) and u have to reach (m,n). The 
 movement allowed are step top, down, right, & left. U can't go to blocks filled with 1 & u can't go to
 that blocks which are visited. Print all possible way to reach (m,n) from (0,0) following the rules.
 */

// Note:- Input should be proper so that we get the output

class Flood_Fill { 

    public static void paths(int a[][], int sr, int sc, String answer, boolean visited[][]) {

        // Base Condition
        if(sr<0 || sc<0 || sr==a.length || sc==a[0].length || a[sr][sc] == 1 || visited[sr][sc] == true){
            return;
        }
        if(sr==a.length-1 && sc==a[0].length-1) { // If reached end, then print the path i.e answer
            System.out.print(answer + " ");
            return;
        }
        
        visited[sr][sc] = true; // If u r in new block then 1st make it true 1st
        paths(a, sr-1, sc, answer + "T", visited); // Top Movement
        paths(a, sr, sc-1, answer + "L", visited); // Left Movement
        paths(a, sr+1, sc, answer + "D", visited); // Down Movement
        paths(a, sr, sc+1, answer + "R", visited); // Right Movement
        visited[sr][sc] = false; // While returning make the block false so that new path can be found.

    }

    public static void main(String[] args) {
        
        int arr [][] = {{0,1,0,0,1},{0,0,1,0,0},{1,0,0,0,0},{0,1,1,0,0},{0,0,1,0,0}};
        boolean visited [][] = new boolean[arr.length][arr[0].length]; // Initially all false
        paths(arr, 0, 0, "", visited); // Starting Position (0,0)

    }
    
}
