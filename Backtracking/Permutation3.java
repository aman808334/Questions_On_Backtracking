
// Permutation

/*
No. of ways in which 'r' items can be placed in 'n' boxes = nPr 
nPr = n!/(n-r)!

Note -> We will create the boxes & solve
*/

class Permutation3 {

    public static void solve(int n, int r){

        int boxes[] = new int[n];
        boolean used[] = new boolean[n+1];
        int boxNumber = 0;
        int selection = 0;
        permutation(boxNumber, boxes, used, selection, r);

    }

    // Boxes on level
    public static void permutation(int boxNumber, int boxes[], boolean used[], int selection, int r){

        // Base Condition
        if(boxNumber==boxes.length){
         if(selection==r){
            for(int i=0; i<boxes.length; i++){
                System.out.print(boxes[i]+ " ");
            }
            System.out.println();
         }  
            return;
        }

        for(int i=1; i<=r; i++){

            if(used[i]==false){
                used[i] = true;
                boxes[boxNumber] = i;
                permutation(boxNumber+1, boxes, used, selection+1, r); // Box is selected for (i+1)th item
                used[i] = false;  // While returning undo the change
                boxes[boxNumber] = 0; // While returning undo the change
            }
        }

        permutation(boxNumber+1, boxes, used, selection, r);  // Box isn't selected
    }

    public static void main(String[] args) {

        int n = 3;
        int r = 2;
        solve(n, r);        
    }  
}
