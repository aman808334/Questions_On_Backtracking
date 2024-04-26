
// All Palindromic Partition

/*
Input -> abaaba
Output -> a, b, a, a, b, a
          aba, aba
          a, baab, a
          aba, a, b, a
          a, b, aa, b, a (All palindromic partition)
*/

class All_Palindromic_Partition {
    
    public static void solve(String str, String answer) { // Initially, answer is empty

        // Base Condition
        if(str.length()==0){
            System.out.println(answer);
            return;
        }

        for(int i=0; i<str.length(); i++){
            String check = str.substring(0, i+1);
            String remaining = str.substring(i+1);
            if(checkPalindrom(check)){
                solve(remaining, answer+ "(" + check + ") ");
            } 
        }
    }

    public static boolean checkPalindrom(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abaaba";
        solve(str,"");
        
    }
}
