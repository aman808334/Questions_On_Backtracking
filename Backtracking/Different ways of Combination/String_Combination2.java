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

class String_Combination2{

    public static void solve(String str, int k){

        HashSet<Character> hs = new HashSet<>();
        for(int i=0; i<str.length(); i++)
            hs.add(str.charAt(i));
          
        String unique = "";
        for (Character c : hs) {
            unique = unique + c;
        }
        
        int currentItem = 1;
        int lastSelectionIndex = -1;
        String ans = "";

        solution(currentItem, k, unique, lastSelectionIndex, ans);

    }

    // Items on level & boxes on option
    public static void solution(int currentItem, int k, String unique, int lastSelectionIndex, String ans){

        // Base Condition
        if(currentItem>k){
          System.out.println(ans);
          return;
        }

        for(int i=lastSelectionIndex+1; i<unique.length(); i++){

            char c = unique.charAt(i);
            solution(currentItem+1, k, unique, i, ans+c);
        }
        
    }

    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 2;
        solve(str, k);
    }
    
}