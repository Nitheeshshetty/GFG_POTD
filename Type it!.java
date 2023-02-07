//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String s = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.minOperation(s);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int minOperation(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            boolean flag = true;
            for(int j=0; j<i; j++)
            {
                if(i+j >= n) 
                    flag = false;
                else if(s.charAt(i+j) != s.charAt(j)) 
                    flag = false;
            }
            if(flag!=false && i>0)
                ans = Math.max(ans, i);
        }
        if(ans == 0) 
            ans++;
        return n-ans+1;
    }
}
