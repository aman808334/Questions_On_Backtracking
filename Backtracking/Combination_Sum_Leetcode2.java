
/*
Input -

Array -> [10,1,2,7,6,1,5] 
Target -> 8

Output -

[[1,1,6],[1,2,5],[1,7],[2,6]]

Explanation - 

We have to use elements in the array. In the answer there isn't any repeating &
permutation

*/

import java.util.*;

class Combination_Sum_Leetcode2 {

    public static List<List<Integer>> solve(int arr[], int target){


        // Putting element of array in HM with its frequency.It will present us for duplicate answer
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0; i<arr.length; i++)
          hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);

    
        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        combinationSum(hm, sum, target, ans, answer);

        return answer;

    }
    

    // Boxes as option i.e element of array as option & we can use an option any no of times
    public static void combinationSum(HashMap<Integer,Integer> hm, int sum, int target, List<Integer> ans,List<List<Integer>> answer){

        // Base Condition
        if(sum==target){
            List<Integer> dc = new ArrayList<>(ans); 
            answer.add(dc);
            return;
        }

        else if(sum>target){
            return;
        }

        for (int i : hm.keySet()) {

            if(hm.get(i)>0){
                if(ans.isEmpty()){
                    hm.put(i, hm.get(i)-1);
                    sum += i;
                    ans.add(i);
                    combinationSum(hm, sum, target, ans,answer);
                    hm.put(i, hm.get(i)+1); // While returning undo the changes
                    sum -= i; // While returning undo the changes
                    ans.remove(ans.size()-1); // While returning undo the changes
                }

                else if(ans.get(ans.size()-1)<=i) {

                    hm.put(i, hm.get(i)-1);
                    sum += i;
                    ans.add(i);
                    combinationSum(hm, sum, target, ans,answer);
                    hm.put(i, hm.get(i)+1); // While returning undo the changes
                    sum -= i; // While returning undo the changes
                    ans.remove(ans.size()-1); // While returning undo the changes
                }
            }
        }
    }
    

    public static void main(String[] args) {

        int arr[] = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(solve(arr, target));
        
              
    }   
}
