//Initial Template for Java

import java.io.*;
import java.util.*;

//User function Template for Java

class Solution{
	public static int countPaths(int N)
	{
	    if(N==1){
	        return 0;
	    }
	    if(N==2){
	        return 3;
	    }
	    long mod=1000000007;
		long[] dp=new long[N+1];
		dp[1]=0;
		dp[2]=3;
		long num=3;
		for(int i=3; i<=N; i++){
		   num=(num*3) % mod;
		   dp[i]=((num) - (dp[i-1]) + mod) % mod;
		}
		int res=(int)(dp[N] % mod);
		return res;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends
