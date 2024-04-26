
// Remove_Invalid_Parentheses

/*
Input -> "()())()"

Output -> ()()()
          (())()

U have to remove the minimum number of brackets and make it valid.           
*/

import java.util.HashSet;
import java.util.Stack;

class Remove_Invalid_Parentheses{

    public static void solve(String str){

        int noOfBracketToRemove = minBracketToRemove(str);
        HashSet<String> hs  = new HashSet<>(); // To avoid duplicate printing
        remove(str, noOfBracketToRemove,hs);
    }

    public static void remove(String str, int noOfBracketToRemove, HashSet<String> hs) {

        // Base Condition
        if(noOfBracketToRemove==0){ // No more bracket to remove
            if(minBracketToRemove(str)==0){ // This means string doesn't contains any invalid parentheses.
             if(!hs.contains(str)) {
               System.out.println(str);
               hs.add(str);
             }
            }
            return;
        }

        for(int i=0; i<str.length(); i++){
            // We will give chance to every parentheses to be removed.
            String left = str.substring(0, i);
            String right = str.substring(i+1);
            remove(left+right, noOfBracketToRemove-1, hs);
        }

    }

    public static int minBracketToRemove(String str) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(') {
              st.push(c);
            }  
            else {
                if(st.isEmpty())
                  st.push(c);
                else if(st.peek()==')')
                  st.push(c);
                else if (st.peek()=='(')
                  st.pop();
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        String str = "()())()";
        solve(str);
    }
}