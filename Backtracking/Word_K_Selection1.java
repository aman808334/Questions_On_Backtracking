
// Word K Selection

/*
U r given a string(may contain duplicate character) & a number 'k'.
U r required to generate & print all way u can select 'k' distinct characters out of the string,
*/

/*
 Approach -

 We know, nCr = No. of ways in which 'r' boxes can be selected out of 'n' boxes (n distinct boxes).
 So, we'll put all the characters of the string in HashSet. The characters in the HS will be the
 total number of boxes & from that we've to select 'k' boxes.
*/

import java.util.HashSet;

class Word_K_Selection1{

    public static void solve(String str, int k){

        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++)
            hs.add(str.charAt(i));
          
        String unique = "";
        for (Character c : hs) {
            unique = unique + c;
        }
        int totalBoxes = hs.size();
        int boxNumber = 0;
        int totalSelection = 0;
        String ans = "";

        solution(totalBoxes, boxNumber, totalSelection, k, unique, ans);

    }

    // Boxes are on level
    public static void solution(int totalBoxes, int boxNumber, int totalSelection, int k, String unique, String ans){

        // Base Condition
        if(boxNumber==totalBoxes){
            if(totalSelection==k){
              System.out.println(ans);
            }
          return;
        }

        char c = unique.charAt(boxNumber);

       

        // Every box has 2 options - I'll be selected or not
        solution(totalBoxes, boxNumber+1, totalSelection+1, k, unique, ans+c); // Selected
        solution(totalBoxes, boxNumber+1, totalSelection, k, unique, ans); // Not Selected
            
        }
    

    public static void main(String[] args) {
        String str = "aabbbccddee";
        int k = 3;
        solve(str, k);
    }
    
}