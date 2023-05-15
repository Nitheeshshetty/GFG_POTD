//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.countBits(N);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long countBits(long N) {
        long count = 0;
        for (int i = 0; i < 31; i++) {
            int x = 1 << i; 
            long y = (N + 1) / (x * 2) * x; 
            long z = (N + 1) % (x * 2) - x; 
            count += y + Math.max(z, 0); 
        }
        return count;
    }
}
        
