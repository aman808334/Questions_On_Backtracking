
// Permutation of String

/*
We'll keep character os level and boxes as options. But in case string has repeating characters, we'll 
get duplicate answers.

To avoid that we'll use an algo. which will say that "if a character has already occurred & if that
character is occurring again, then that character will be placed only in the boxes which are a/f 
the box in which that character was placed previously".
*/

import java.util.HashMap;

class String_Permutation2{

    public static void solve(String str){

        char boxes[] = new char[str.length()]; 
        int itemNumber = 0;

        // Creating HashMap to know which element has already occurred & there last occurrence index
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++)
         hm.put(str.charAt(i), -1);

        permutation(itemNumber, str, boxes, hm);

    }

    public static void permutation(int itemNumber, String str, char boxes[], HashMap<Character,Integer> hm){

    // Base Condition
    if(itemNumber==str.length()){
        display(boxes);
        return;
    }

    char c = str.charAt(itemNumber);
    int lastOccurrence = hm.get(c); // If it doesn't contain then, it will return -1.


    for(int i=lastOccurrence+1; i<boxes.length; i++){

        if(boxes[i]== '\u0000') {// Box is empty
            boxes[i] = c;
            hm.put(c, i);
            permutation(itemNumber+1, str, boxes, hm);
            boxes[i] = '\u0000'; // While returning undo the change
            hm.put(c, lastOccurrence); // While returning undo the change
        }
    }  
  }

    public static void display(char boxes[]){
        for(int i=0; i<boxes.length; i++){
            System.out.print(boxes[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        String str = "abab";
        solve(str);
    }
}