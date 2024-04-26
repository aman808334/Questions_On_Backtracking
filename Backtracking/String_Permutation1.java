
// Permutation of String

/*

Example -

str = "abab"

In this we have 4 boxes & 4 characters.

We'll keep boxes on level. But in this case boxes won't have option to to be empty b/c no. of boxes and
no. of items are same.

All the items aren't unique. So, we will use HashMap

*/

import java.util.HashMap;

class String_Permutation1{

    public static void solve(String str){

        // Putting characters of string in HashMap
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++)
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
        

        int totalBox = str.length();
        int currentBox = 1;
        String answer = "";

        permutation(totalBox, currentBox, hm, answer);

    }

    public static void permutation(int totalBox, int currentBox, HashMap<Character, Integer> hm, String answer){

        // Base Condition
        if(currentBox>totalBox){
            System.out.println(answer);
            return;
        }

        for (char c : hm.keySet()) {
            int freq = hm.get(c);
            if(freq>0){
                hm.put(c, freq-1);
                permutation(totalBox, currentBox+1, hm, answer+c);
                hm.put(c, freq); // While returning undo the change
            }
            
        }
    }

    public static void main(String[] args) {
        
        String str = "abab";
        solve(str);
    }
}