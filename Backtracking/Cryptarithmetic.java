
// Cryptarithmetic

/*
U r given 3 strings & u have to give each character a number(0-9). Such that sum of 1st & 2nd string
is equal to the 3rd. 

Rules -

Each character will be given only one number
One number can't be assigned to more than one character
*/

import java.util.HashMap;

public class Cryptarithmetic {

    public static void sol(String str1, String str2, String str3){

        // Creating StringBuilder to store unique character of all 3 strings
        StringBuilder unique = new StringBuilder("");

        // Creating HashMap & putting all the character of 3 strings with value as -1.
        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0; i<str1.length(); i++){
            if(!hm.containsKey(str1.charAt(i))) {
            hm.put(str1.charAt(i), -1);
            unique = unique.append(str1.charAt(i));
            }
        }

        for(int i=0; i<str2.length(); i++){
            if(!hm.containsKey(str2.charAt(i))) {
            hm.put(str2.charAt(i), -1);
            unique = unique.append(str2.charAt(i));
            }
        }

        for(int i=0; i<str3.length(); i++){
            if(!hm.containsKey(str3.charAt(i))) {
            hm.put(str3.charAt(i), -1);
            unique = unique.append(str3.charAt(i));
            }
        }

        // Creating boolean array of size '10'.This will help us to know that which number has be used.
        boolean usedNumber[] = new boolean[10];

        solve(unique, hm, usedNumber, str1, str2, str3, 0);
    }

    public static void solve(StringBuilder unique, HashMap<Character,Integer> hm, boolean usedNumber[], String str1, String str2, String str3, int index) { // Initially index is '0'

    // Base Condition
    if(index == unique.length()){
        int num1 = calculateSum(str1,hm);
        int num2 = calculateSum(str2,hm);
        int num3 = calculateSum(str3,hm);

        if(num1+num2 == num3) {
            // We have to print the answer in lexicographical order.
            for(char c = 'a'; c<='z'; c++) {
                if(hm.containsKey(c)) {
                    System.out.print(c + "-" + hm.get(c) + "  ");
                }
            }
            System.out.println("\n");
        }
        return;
    }

    // Will work on unique string. Every characters will has 10 options i.e 0-9. So calls inside loop
    for(int num=0; num<=9; num++){
        if(usedNumber[num]==false){ // If 'false' that means that number isn't used
          hm.put(unique.charAt(index), num);
          usedNumber[num] = true;
          solve(unique, hm, usedNumber, str1, str2, str3, index+1);
          hm.put(unique.charAt(index), -1); // Undo the chances while coming back
          usedNumber[num] = false;
          
        }
    }
}

public static int calculateSum(String s, HashMap<Character,Integer> hm) {

    String sum = "";
    for(int i=0; i<s.length(); i++){
        sum = sum + hm.get(s.charAt(i));
    }
    return Integer.parseInt(sum);

}

    public static void main(String[] args) {
        String str1 = "send";
        String str2 = "more";
        String str3 = "money";
        sol(str1, str2, str3);
    }
    
}
