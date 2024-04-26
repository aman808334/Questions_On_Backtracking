
// Max Score

/*
 
1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet from a to z.
2. You have to find the maximum score of any valid set of words formed by using the given alphabets.
3. A word can not be used more than one time.
4. Each alphabet can be used only once.
5. It is not necessary to use all the given alphabets.

Input Format-

A number N representing number of words
N space separated strings
A number M representing number of alphabets(might be repeating)
M space separated characters
26 numbers representing scores of unique alphabets from a to z.

Output Format -

Check the sample output.

Sample Input -

4
dog cat dad good
9
a b c d d d g o o 
1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 .... (total 26)

Sample Output -

23

 */

import java.util.HashMap;

class Max_Score {

    static int maxSum = Integer.MIN_VALUE;

    public static int findMax(String words[], char allowedChar[], int score[], int index){ // Initially Index is 0

        // Putting array of allowed character into HashMap with frequency
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0; i<allowedChar.length; i++){
            hm.put(allowedChar[i],hm.getOrDefault(allowedChar[i], 0)+1);
        }
         int sum = 0;
         max(words, hm, score, sum, index);

       return maxSum;
    }

     public static void max(String words[], HashMap<Character,Integer> hm, int score[], int sum, int index){
         

        // Base Condition
        if(index == words.length){
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // Two calls - yes & no
        String currentWord = words[index];
        // Checking if all character of currentWord is in HashMap or not
        boolean flag = true;
        int s = 0;
        for(int i=0; i<currentWord.length(); i++){
            if(hm.containsKey(currentWord.charAt(i)) && hm.get(currentWord.charAt(i))>0) {
                hm.put(currentWord.charAt(i), hm.get(currentWord.charAt(i))-1);
                s = s + score[currentWord.charAt(i) - 'a'];
            }    
            else {
              flag = false;
            }  
                 
        }

        if(flag){
            max(words, hm, score, sum+s, index+1); // Yes call
        }  

        // While returning undo the changes
        for(int i=0; i<currentWord.length(); i++){
            if(hm.containsKey(currentWord.charAt(i))) {
                hm.put(currentWord.charAt(i), hm.get(currentWord.charAt(i))+1);
            }      
        }

        
        max(words, hm, score, sum, index+1); // No call

     }

    public static void main(String[] args) {
        String words [] = { "dog", "cat", "dad","good"};
        char allowedChar [] = {'a','b', 'c', 'd', 'd','d', 'g','o', 'o'};
        int score [] = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(findMax(words, allowedChar, score, 0));
    }
    
}
