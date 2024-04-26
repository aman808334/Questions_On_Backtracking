
// Word Break

/*
Input -

Array of Strings = {"micro", "soft", "hi", "ring", "hiring", "microsoft"}
String = "microsofthiring"

Output - 

micro soft hi ring 
micro soft hiring 
microsoft hi ring 
microsoft hiring

*/

import java.util.HashSet;

class Word_Break {
    
    public static void solve(String arr[], String str){

        // Putting String of array in HashSet. So that we can find it in O(1).
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<arr.length; i++)
            hs.add(arr[i]);
        
            String answer = "";
            solution(str, hs, answer);
    }

    public static void solution(String str, HashSet<String> hs, String answer) { // Initially Empty

        // Base Condition
        if(str.length()==0){
            System.out.println(answer);
            return;
        }
        for(int i=0; i<str.length(); i++){
            String s = str.substring(0, i+1);
            String remaining = str.substring(i+1);
            if(hs.contains(s))
              solution(remaining, hs, answer + s + " ");
        }

    }
    public static void main(String[] args) {
        
        String arr[] = {"micro", "soft", "hi", "ring", "hiring", "microsoft"};
        String  str = "microsofthiring";
        solve(arr, str);
    }
}
