import java.util.ArrayList;

public class Array_Combination_SNS {

    public static void solve(int arr[], int target){
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        combination(0, arr, sum, target, ans);

    }

    // Boxes on level i.e elements of arrays on level and each element has 2 options
    public static void combination(int index, int arr[], int sum, int target, ArrayList<Integer> ans){

        // Base Condition
        if(index==arr.length){
            if(sum==target){
                System.out.println(ans);
            }
          return;  
        }

        sum += arr[index];
        ans.add(arr[index]);
        combination(index+1, arr, sum, target, ans); // Selected 
        sum -= arr[index]; //While returning undo the changes
        ans.remove(ans.size()-1); //While returning undo the changes

        combination(index+1, arr, sum, target, ans); // Not Selected call
    }

    public static void main(String[] args) {
        int arr[] = {2,3,1,2,3};
        int target = 5;
        solve(arr, target);
    }
    
}
