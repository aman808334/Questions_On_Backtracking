
// Friends Pair

/*
You are given an integer n, which represents friends numbered from 1 to n.
Each one can remain single or can pair up with some other friend.
You have to print all the configurations in which friends can remain single or can be paired up.
*/

class Friends_Pairing {

    public static void find(int n){

        boolean used[] = new boolean[n+1];
        solution(1, n, used, ""); 

    }

    public static void solution(int i, int n, boolean used[], String ans){ // Initially ans is empty

        // Base Condition
        if(i>n){
            System.out.println(ans);
            return;
        }


        if(used[i]==true){
            solution(i+1, n, used, ans);
        }
        else {
            used[i] = true;
            solution(i+1, n, used, ans+ "(" +i +")"); // Won't pair with anyone
            for(int j =i+1; j<=n; j++) { // Will avoid permutation in answer
                if(used[j]==false) { 
                   used[j] = true;
                   solution(i+1, n, used, ans+"(" + i + "," + j + ")"); // Pair with other frnds.
                   used[j] = false; // Undo the changes while coming back
                }
            }
            used[i] = false; // Undo the changes while coming back
        }

    }

    public static void main(String[] args) {
        int n = 3;
        find(n);
    }
}