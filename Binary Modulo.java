//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			String s = str[0];
			int m = Integer.parseInt(str[1]);
			Solution obj = new Solution();
			System.out.println(obj.modulo(s,m));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int modulo(String s, int m) {
		int mul=1;
        int ans=0;
        int j=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            mul=mul%m;
            ans+= mul*(s.charAt(i)=='1'?1:0);
            ans%=m;
            mul*=2;
        }
        return ans;
	}
}
