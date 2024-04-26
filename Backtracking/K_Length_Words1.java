
// K length Words

/*
U r given a string(may contain duplicate character) & a number 'k'.
U r required to generate & print all 'k' length words of distinct characters by using characters of the 
given string

Example -

Input -

String = "abcabc"
k = 2

Output -

ab,ba,ac,ca,bc,cb. 

Note -> Basically, we've to find nPr
*/

import java.util.HashSet;

public class K_Length_Words1 {

    public static void solve(String str, int k){

        // Will put all the characters of the given string in HS, to get unique characters
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++)
            hs.add(str.charAt(i));
          
        String unique = "";
        for (Character c : hs)
            unique = unique + c;

        char boxes[] = new char[k];
        int currentSelection = 0;
        int currentItem = 0;
        

        
        solution(currentItem, unique, currentSelection, k, boxes);
        
    }
    // Less one will be the boxes & more one will be the items. 
    // More one will have the option whether they will go to the boxes or not, if then to which one
    public static void solution(int currentItem, String unique, int currentSelection, int k, char boxes[]){

        //Base Condition
        if(currentItem == unique.length()){
            if(currentSelection==k)
              display(boxes);
          return;
        }

        char c = unique.charAt(currentItem);

        for(int i=0; i<boxes.length; i++){

            if(boxes[i]=='\u0000'){
                boxes[i] = c;
                solution(currentItem+1, unique, currentSelection+1, k, boxes); 
                boxes[i] = '\u0000'; // While returning undo the changes
            }
        }

        solution(currentItem+1, unique, currentSelection, k, boxes); // No Call
    }

    public static void display(char boxes[]){
        for(int i=0; i<boxes.length; i++)
          System.out.print(boxes[i]);
        
        System.out.println();  
    }

    public static void main(String[] args) {

        String str = "abcabc";
        int k = 2;
        solve(str, k);
        
    }
    
}
