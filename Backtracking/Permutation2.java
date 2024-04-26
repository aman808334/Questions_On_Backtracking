
// Permutation

/*
No. of ways in which 'r' items can be placed in 'n' boxes = First select 'r' boxes & then arrangement
No. of ways in which 'r' items can be placed in 'n' boxes = nCr*r!
Basically, nPr = nCr*r!
*/

class Permutation2{

    public static void solve(int n, int r){ 

        int noOfSelection = 0;
        String answer = "";
        boolean usedItem [] = new boolean[r];
        permutation(n, 1, r, noOfSelection, usedItem, answer);
    }

    public static void permutation(int n, int boxNumber, int r, int noOfSelection, boolean usedItem[], String answer){ // Initially, noOfSelection is '0' & boxNumber is '1'

        //Base Condition
        if(boxNumber>n){
            if(noOfSelection==r)
              System.out.println(answer);
              
         return;
        }

        for(int i=0; i<r; i++) {
            if(usedItem[i]==false){
              usedItem[i] = true;  
              permutation(n, boxNumber+1, r, noOfSelection+1, usedItem, answer + (i+1)); // Box is selected for (i+1)th item
              usedItem[i] = false; // While returning undo the change

            }
        }

        permutation(n, boxNumber+1, r, noOfSelection, usedItem, answer+"_"); // Box isn't selected
    }

    public static void main(String[] args) {
        int n = 4; // Total no boxes
        int r = 2; // No. of boxes to be selected
        solve(n, r);
    }
    
}
