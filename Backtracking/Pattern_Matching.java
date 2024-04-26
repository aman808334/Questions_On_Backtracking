
// Pattern Matching

/*
 Input -

 String str = mzaddytzaddy
 String pattern = abcb

 Output -

 a -> m  b -> zaddy  c -> t  
 a -> mz  b -> addy  c -> tz  
 a -> mza  b -> ddy  c -> tza  
 a -> mzad  b -> dy  c -> tzad  
 a -> mzadd  b -> y  c -> tzadd 

 */

import java.util.HashMap;
import java.util.HashSet;

class Pattern_Matching {

    public static void solve(String pattern, String str) {

        // Creating HashMap, it will have the information that which char of pattern is mapped to what
        HashMap<Character,String> hm = new HashMap<>();
        
        String originalPattern = pattern; // Passing original pattern to print answer in order.
        solution(pattern, str, hm, originalPattern);
    }

    public static void solution(String pattern, String str, HashMap<Character,String> hm, String originalPattern){

        // Base Condition
        if(pattern.length()==0){ // All characters of pattern in mapped
            if(str.length()==0) {// Str length should also be '0'. i.e. no char should be in str which isn't mapped
            // To know which character is already printed. To avoid duplicate printing
            HashSet<Character> hs = new HashSet<>();
             for(int i=0; i<originalPattern.length(); i++){ // To print in order
                char x = originalPattern.charAt(i);
                if(hs.contains(x)==false) {
                 System.out.print(x + " -> " + hm.get(x) + "  ");
                 hs.add(x);
                }
             }
             System.out.println();
            }
            return;
        }

        char c = pattern.charAt(0);
        String remainingPattern = pattern.substring(1);

        if(hm.containsKey(c)){
            String valueOfc = hm.get(c);
            if(valueOfc.length()<=str.length()) {
                String toCompare = str.substring(0, valueOfc.length());
                String remainingStr = str.substring(valueOfc.length());
                if(valueOfc.equals(toCompare)){
                    solution(remainingPattern, remainingStr, hm, originalPattern);
                }
            }
        }

        else{
            for(int i=0; i<str.length(); i++){
                String toMap = str.substring(0, i+1);
                String remainingStr = str.substring(i+1);
                hm.put(c, toMap);
                solution(remainingPattern, remainingStr, hm, originalPattern);
                hm.remove(c); // While returning undo the changes
            }
        }


    }

    public static void main(String[] args) {
        String str = "mzaddytzaddy";
        String pattern = "abcb";
        solve(pattern, str);

    }
 }