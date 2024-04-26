
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

class K_Length_Words2 {

    public static void solve(String str, int k){

        // Will put all the characters of the given string in HS, to get unique characters
        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++)
            hs.add(str.charAt(i));
          
        String unique = "";
        for (Character c : hs)
            unique = unique + c;

        int itemNumber = 0;
        boolean used[] = new boolean[unique.length()]; // To Know which box has been used
        String answer = ""; 
        
        solution(itemNumber, unique, k, used, answer);
        
    }

     // We will put boxes as option. No. of options is equal to no. of characters in unique string
     public static void solution(int itemNumber, String unique, int k, boolean used[], String answer){

        // Base Condition
        if(itemNumber==k){
            System.out.println(answer);
            return;
        }

        for(int i=0; i<unique.length(); i++){
            if(used[i]==false) {
               char c = unique.charAt(i);
               used[i] = true;
               solution(itemNumber+1, unique, k, used, answer + c);
               used[i] = false; // While returning undo the changes
            } 
        }
     }

    public static void main(String[] args) {

        String str = "abcabc";
        int k = 2;
        solve(str, k);
        
    }
    
}
