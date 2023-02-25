//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) 
    {
        int i=0, j=0;
        int N = S.length(), M  = T.length();
        while(i<N && j < M){
            int moves =0;
            String str = "";
            while(j < M && T.charAt(j) >='0' && T.charAt(j) <='9') {
                str+= T.charAt(j);
                moves = moves*10 + (T.charAt(j) - '0');
                j++;
            }
            i+= moves;
            if(i==N && j == M) 
                return 1;
            if(i>= S.length() || j>=T.length()) 
                return 0;
            if(S.charAt(i) != T.charAt(j)) 
                return 0;
            i++;
            j++;
        }
        return 1;
    }
}
