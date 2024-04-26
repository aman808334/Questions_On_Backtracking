
/*
Input -

Array -> [2,3,6,7] 
Target -> 7

Output -

[[2,2,3],[7]]

Explanation - 

We can use elements in the array any number of times. In the answer there isn't any repeating &
permutation

*/

import java.util.*;

class Combination_Sum_Leetcode_1 {

    public static List<List<Integer>> solve(int arr[], int target){

        int sum = 0;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        combinationSum(arr, sum, target, ans, answer);

        return answer;

    }
    

    // Boxes as option i.e element of array as option & we can use an option any no of times
    public static void combinationSum(int arr[], int sum, int target, List<Integer> ans,List<List<Integer>> answer){

        // Base Condition
        if(sum==target){

            List<Integer> dc = new ArrayList<>(ans); 
            answer.add(dc);
            return;
        }

        else if(sum>target){
            return;
        }

        for(int i=0; i<arr.length; i++){
            // These if & else if condition will prevent permutation
            if(ans.isEmpty()){

            sum += arr[i];
            ans.add(arr[i]);
            combinationSum(arr, sum, target, ans,answer);
            sum -= arr[i]; // While returning undo the changes
            ans.remove(ans.size()-1); // While returning undo the changes

            }

            else if(ans.get(ans.size()-1)<=arr[i]) {

            sum += arr[i];
            ans.add(arr[i]);
            combinationSum(arr, sum, target, ans,answer);
            sum -= arr[i]; // While returning undo the changes
            ans.remove(ans.size()-1); // While returning undo the changes

            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {2,3,6,7};
        int target = 7;
        System.out.println(solve(arr, target));
        
              
    }   
}
