
// Permutation

/*
No. of ways in which 'r' items can be placed in 'n' boxes = nPr 
nPr = n!/(n-r)!

Note -> In permutation, we will keep items as level & boxes as options.
*/

class Permutation1{

    public static void permutation(int boxes[], int r, int currentItemNo){ // Initially currentItem is '1'

    // Base Condition
    if(currentItemNo>r){
        display(boxes);
        return;
    }

    // Boxes are options. So, call inside loop 
    for(int i=0; i<boxes.length; i++){
     if(boxes[i]==0){
        boxes[i] = currentItemNo; // Place the item in the box
        permutation(boxes, r, currentItemNo+1);
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
        int n = 3; // Total no. of boxes
        int r = 2; // No.of items to be placed
        int boxes[] = new int[n];
        permutation(boxes, r, 1);
    }
}