
// Crossword Puzzle

/*
 Sample Input -

 2D Array :-
 
 + - + + + + + + + +
 + - + + + + + + + +
 + - + + + + + + + +
 + - - - - - + + + +
 + - + + + - + + + +
 + - + + + - + + + +
 + + + + + - + + + +
 + + - - - - - - + +
 + + + + + - + + + +
 + + + + + - + + + +

 Array of String - 

 {"DELHI", "ICELAND", "ANKARA", "LONDON"}

 Output - 

 + L + + + + + + + +
 + O + + + + + + + +
 + N + + + + + + + +
 + D E L H I + + + +
 + O + + + C + + + +
 + N + + + E + + + +
 + + + + + L + + + +
 + + A N K A R A + +
 + + + + + N + + + +
 + + + + + D + + + +

 */
class Crossword_Puzzle {

    public static void solvePuzzle(char arr[][], String words[],int index){ // Initially at 0

        // Base Condition
        if(index==words.length){
            display(arr);
            return;
        }

        String word = words[index];

        // We'll try in every block
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                // If block contains '-' or character that is in beginning of the word then we will check
                if(arr[i][j]=='-' || arr[i][j]== word.charAt(0)) {
                    if(canPlaceWordHor(arr, word, i, j)) {
                        boolean wePlacedHor [] = placeWordHor(arr,word,i,j);
                        solvePuzzle(arr, words,index+1); // A/f placing move to next word
                        unPlaceWordHor(arr, wePlacedHor, i, j); // While returning undo the changes 
                    }                  

                    if(canPlaceWordVer(arr, word, i, j)) {
                        boolean wePlacedVer [] = placeWordVer(arr,word,i,j);
                        solvePuzzle(arr, words,index+1); // A/f placing move to next word
                        unPlaceWordVer(arr, wePlacedVer, i, j); // While returning undo the changes
                    }
                }
            }
        } 
    }
    
    public static boolean canPlaceWordHor(char arr[][], String word, int i, int j){
        if(j-1 >= 0 && arr[i][j-1] != '+') // Left side exits & isn't '+' then false
          return false;

        else if (j+word.length() < arr[0].length && arr[i][j+word.length()] != '+') // Right side exits & isn't '+' then false
          return false; 

         // Above both conditions will ensure that it is a perfect fit. Now will check in that perfect place
         for(int jj=0; jj<word.length(); jj++) {

            if(j+jj >= arr[0].length)
              return false;

            if(arr[i][j+jj] == '-' || arr[i][j+jj] == word.charAt(jj)) 
               continue;
             else
               return false;   
         }

         return true;
    }
    
    public static boolean[] placeWordHor(char arr[][], String word, int i, int j){

        // Creating boolean array to store what we have put
        boolean wePlaced[] = new boolean[word.length()];
        for(int jj=0; jj<word.length(); jj++) {
            if(arr[i][j+jj]=='-'){
                arr[i][j+jj] = word.charAt(jj); // Put the character in correct block
                wePlaced[jj] = true; // Mark is boolean array that we've put that character
            }
        }

        return wePlaced;
    }

    public static void unPlaceWordHor(char arr[][], boolean wePlacedHor[], int i, int j){
        
        for(int jj=0; jj<wePlacedHor.length; jj++) {
            if(wePlacedHor[jj] == true){
                arr[i][j+jj] = '-'; // While returning, removing the word that we placed
                wePlacedHor[jj] = false;
            }
        }
        
    }

    public static boolean canPlaceWordVer(char arr[][], String word, int i, int j){
        if(i-1 >= 0 && arr[i-1][j] != '+') // Left side exits & isn't '+' then false
          return false;

        else if (i+word.length() < arr.length && arr[i+word.length()][j] != '+') // Right side exits & isn't '+' then false
          return false; 

         // Above both conditions will ensure that it is a perfect fit. Now will check in that perfect place
         for(int ii=0; ii<word.length(); ii++) {

            if(i+ii >= arr.length)
              return false;

            if(arr[i+ii][j] == '-' || arr[i+ii][j] == word.charAt(ii)) 
               continue;
             else
               return false;   
         }

         return true;
    }

     public static boolean[] placeWordVer(char arr[][], String word, int i, int j){

        // Creating boolean array to store what we have put
        boolean wePlaced[] = new boolean[word.length()];
        for(int ii=0; ii<word.length(); ii++) {
            if(arr[i+ii][j]=='-'){
                arr[i+ii][j] = word.charAt(ii); // Put the character in correct block
                wePlaced[ii] = true; // Mark is boolean array that we've put that character
            }
        }
        
        return wePlaced;
    }

    public static void unPlaceWordVer(char arr[][], boolean wePlacedHor[], int i, int j){
        
        for(int ii=0; ii<wePlacedHor.length; ii++) {
            if(wePlacedHor[ii] == true){
                arr[i+ii][j] = '-'; // While returning, removing the word that we placed
                wePlacedHor[ii] = false;
            }
        }
        
    }

    public static void display(char arr[][]) {

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char arr[][] = {{'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','-','-','-','-','+','+','+','+'},
                        {'+','-','+','+','+','-','+','+','+','+'},
                        {'+','-','+','+','+','-','+','+','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'},
                        {'+','+','-','-','-','-','-','-','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'}};

        String words[] = {"DELHI", "ICELAND", "ANKARA", "LONDON"};
        solvePuzzle(arr,words,0); 
    }
}
