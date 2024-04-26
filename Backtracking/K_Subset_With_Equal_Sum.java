
// K subset with equal sum

/*
 U r given an array of n distinct numbers
 U've to divide this 'n' integers into 'k' not empty subsets such that the sum of the numbers of every subset is the same.
 */

import java.util.ArrayList;

class K_Subset_With_Equal_Sum {

    public static void solve(int arr[], int k){

        // If arr.length is smaller than k. Then not possible
        if(arr.length<k)
          System.out.println(-1);
        
        // If the sum of all the elements of the array isn't completely divisible by 'k' then all subsets can't have the same sum.
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }

        if(sum%k != 0)
          System.out.println(-1);

          int eachSubsetSum [] = new int[k]; // This array with contain the sum of each subset

          // AL of AL, which will contain the subset. Initially empty
          ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
          for(int i=0; i<k; i++)
            ans.add(new ArrayList<>());

            int countOfNonEmptySet = 0;

         solution(arr, 0, k, eachSubsetSum, countOfNonEmptySet, ans);  

    }

    public static void solution(int arr[], int index, int k, int eachSubsetSum [], int countNonEmpty,  ArrayList<ArrayList<Integer>> ans) { // Initially index is '0' & nonEmptySet is also '0'
       
       // Base Condition
       if(index == arr.length){
         if(countNonEmpty==k) {
           // Checking if sum of all 'k' subsets are equal or not
            boolean flag = true;
            for(int i=0; i<eachSubsetSum.length-1; i++){
                if(eachSubsetSum[i] != eachSubsetSum[i+1]){
                    flag = false;
                    break;
                }
            }
            if(flag)
              System.out.println(ans);
        }  
         return;
       
    }

       for(int i=0; i<ans.size(); i++){

        if(ans.get(i).size()>0){ // If size of inner AL is greater than 0

            ans.get(i).add(arr[index]);
            eachSubsetSum[i] += arr[index];
            solution(arr,index+1, k, eachSubsetSum, countNonEmpty, ans);
            ans.get(i).remove(ans.get(i).size()-1); // While returning undo the changes
            eachSubsetSum[i] -= arr[index];


        }
        else{ 
            
            // Adding in empty AL
            ans.get(i).add(arr[index]);
            eachSubsetSum[i] += arr[index];
            solution(arr,index+1, k, eachSubsetSum, countNonEmpty+1, ans);
            ans.get(i).remove(ans.get(i).size()-1); // While returning undo the changes
            eachSubsetSum[i] -= arr[index];
            break; // Break b/c if the set is empty then we've to add to only one empty set.

        }
     }
   }
    
    public static void main(String[] args) {
        int arr[] = {3,1,2,3};
        int k = 3;
        solve(arr, k);
    }
    
}
