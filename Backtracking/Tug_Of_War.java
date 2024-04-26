
// Tug of war

/*
Given an array. We've to divide it in 2 equal parts(if the length of the array is even). If length is
odd then one of the parts will have one extra element.

A/f all such divisions. Print that part which will have a minimum difference. 

Input -> arr[] = {1,2,3,4,5,6,7};
Output -> [1, 2, 4, 7] [3, 5, 6]
*/

import java.util.ArrayList;

class Tug_Of_War {

    static int min = Integer.MAX_VALUE;
    static String ans = "";

    public static String solve(int arr[]){

        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        int sumSet1 = 0;
        int sumSet2 = 0;
        int index = 0;
        parts(index,arr, set1, set2, sumSet1, sumSet2);

      return ans;  

    }

    public static void parts(int index,int arr[], ArrayList<Integer> set1, ArrayList<Integer> set2, int sumSet1, int sumSet2){

        // Base Condition
        if(index==arr.length){
            if(set1.size()== set2.size() || Math.abs(set1.size()-set2.size())==1) { // Size of set should be equal or difference b/w them should be '1'
            int diff = Math.abs(sumSet1-sumSet2);
              if(diff<min) {
                min = diff;
                ans = set1 + " " + set2;
              }
            }
          return;
        }

        // Every element of the array has 2 options.
        if(set1.size() < (arr.length+1)/2) {  // This if statement is written for optimization
           set1.add(arr[index]);
           parts(index+1, arr, set1, set2, sumSet1+arr[index], sumSet2); // Adding in set1
           set1.remove(set1.size()-1); // While returning undo the change
        }

        if(set2.size() < (arr.length+1)/2) { // This if statement is written for optimization
           set2.add(arr[index]);
           parts(index+1, arr, set1, set2, sumSet1, sumSet2+arr[index]); // Adding in set2
           set2.remove(set2.size()-1); // While returning undo the change
        }
      
    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6,7};
        System.out.println(solve(arr));
    }
    
}
