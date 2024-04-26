
// Combination

/*
No. of ways in which 'r' boxes can be selected out of 'n' boxes = nCr 
nCr = n!/r!*(n-r)!

Note -> In combination, we will keep boxes as level &  selected or not selected as options.
*/


class Combination1 {

    public static void combination(int n, int boxNumber, int r, int noOfSelection, String answer){ // Initially, noOfSelection is '0' & boxNumber is '1'

        //Base Condition
        if(boxNumber>n){
            if(noOfSelection==r)
              System.out.println(answer);
              
         return;
        }

        // Every boxes has two options - To get selected & not to get selected.
        combination(n, boxNumber+1, r, noOfSelection+1, answer+"S"); // Box is selected
        combination(n, boxNumber+1, r, noOfSelection, answer+"_"); // Box isn't selected
    }

    public static void main(String[] args) {
        int n = 4; // Total no boxes
        int r = 2; // No. of boxes to be selected
        int noOfSelection = 0;
        String answer = "";
        combination(n, 1, r, noOfSelection, answer);
    }
    
}
