
// K Swaps

/*
Largest number possible a/f atmost 'k swaps'.
*/

class K_Swaps {

    static int max = Integer.MIN_VALUE;

    public static int largestNumber(String number, int k){

        // Base Condition
        if(k==0){
            return max;
        }

        if(max<Integer.parseInt(number))
         max = Integer.parseInt(number);

        for(int i=0; i<number.length()-1; i++){
            for(int j=i+1; j<number.length(); j++){
                if(number.charAt(i)<number.charAt(j)){
                    String swapped = swap(number,i,j);
                    largestNumber(swapped, k-1);
                }
            }
        }

        return max;

    }

    public static String swap(String number, int i, int j){

        char ith = number.charAt(i);
        char jth = number.charAt(j);
        String left = number.substring(0, i);
        String middle = number.substring(i+1, j);
        String right = number.substring(j+1);

        return left + jth + middle + ith + right;
    }

    public static void main(String[] args) {
        String number = "123456";
        int k = 4;
        System.out.println(largestNumber(number, k));
    }
    
}
