
// Palindromic Permutation

/*
 U are given a string. U have to print all its palindromic permutation. If it doesn't exist then print -1.
*/

 // Important -

/*
  If the occurrence of all the characters in the string is even then palindromic permutation is possible.
  Palindromic permutation is also possible if the occurrence of only one character is odd.
*/

import java.util.HashMap;

class Palindromic_Permutation {

    public static void find(String str){

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
        }

        int oddCount = 0;
        char oddChar = '@'; // Any Random Character
        int newLength = str.length()/2; // length of string will be half.
        for (char i : hm.keySet()) {
            if(hm.get(i)%2==1){
                oddCount++;
                oddChar = i;
            }
            hm.put(i, hm.get(i)/2);
        }

        // If number of odd character is more than 1, then palindromic permutation isn't possible
        if(oddCount>1) {
            System.out.println(-1);
        }

        findPermutation(1,hm, oddChar, newLength, "");
    }

    public static void findPermutation(int i,HashMap<Character,Integer> hm, char oddChar, int length, String ans){

        // Base Condition
        if(i>length){
            
            String rev = "";
            for(int k=ans.length()-1; k>=0; k--) {
                rev = rev + ans.charAt(k);
            }
            String result = "";
            if(oddChar != '@')
              result = ans + oddChar + rev;
            else 
              result = ans + rev;  

            System.out.println(result);  

            return;
        }

        // Call inside the loop 
        for (char c : hm.keySet()) {
            int freq = hm.get(c);
            if(freq>0){
                hm.put(c, freq-1);
                findPermutation(i+1, hm, oddChar, length, ans+c);
                hm.put(c, freq); // At returning time, undo the changes.
            }
        }


    }

    public static void main(String[] args) {
        String str = "aabbccc";
        find(str);
    }
    
}
