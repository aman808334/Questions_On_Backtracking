
// Partition in k subset

/*
 Input - 3,2 (n,k respectively)

 Output - [[1,23],[12,3],[13,2]]

 */

import java.util.ArrayList;

class Partition_In_K_Subset {

    public static void solve(int i, int n, int k, int countNonEmpty, ArrayList<ArrayList<Integer>> ans){

        // Base Condition
        if(i>n){
            if(countNonEmpty == k)
              System.out.println(ans);
            return;
        }

        for(int j=0; j<ans.size(); j++){

            if(ans.get(j).size()>0){ // If size of inner AL is greater than 0

                ans.get(j).add(i);
                solve(i+1, n, k, countNonEmpty, ans);
                ans.get(j).remove(ans.get(j).size()-1); // While returning undo the changes


            }
            else{
                
                // Adding in empty AL
                ans.get(j).add(i);
                solve(i+1, n, k, countNonEmpty+1, ans);
                ans.get(j).remove(ans.get(j).size()-1);  // While returning undo the changes
                break; // Break b/c if the set is empty then we've to add to only one empty set.

            }
        }
    }

    public static void main(String[] args) {
        
        int n = 3;
        int k = 2;

         // AL of AL, which will contain the subset. Initially empty
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); 
        for(int i=0; i<k; i++)
            ans.add(new ArrayList<>());
        
        int countOfNonEmptySet = 0; // Initially, all sets are empty. So, count is 0
        solve(1, n, k, countOfNonEmptySet, ans);
    }
    
}