
// Combination

/*
 nCr = nPr/r!
*/

class Combination2 {

    public static void solve(int n, int r){

        int currentItem = 1;
        int lastUpdatedIndex = -1; 
        int boxes[] = new int[n];
        combination(boxes, currentItem, r, lastUpdatedIndex);

    }
    // Items on level & boxes as options
    public static void combination(int boxes[], int currentItem, int r, int lastUpdatedIndex){

        // Base Condition
        if(currentItem>r){
            display(boxes); 
            return;
        }

        for(int i=lastUpdatedIndex+1; i<boxes.length; i++){

            if(boxes[i]==0){
                boxes[i] = currentItem;
                lastUpdatedIndex = i;
                combination(boxes, currentItem+1, r, lastUpdatedIndex);
                boxes[i] = 0; // While returning undo the change
               
            }
        }

    }

    public static void display(int boxes[]){

        for(int i=0; i<boxes.length; i++)
          System.out.print(boxes[i] + " ");

        System.out.println();  
    }

    public static void main(String[] args) {
        int n = 4;
        int r = 1;
        solve(n, r);
    }
    
}
