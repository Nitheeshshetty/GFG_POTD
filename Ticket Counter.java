//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int N,int K)
    {
        Deque<Integer>dq = new ArrayDeque();
        for(int i=1;i<=N;i++) dq.add(i);
        int ans = 0,ind = K;
        while(!dq.isEmpty())
        {
            while(ind!=0 && !dq.isEmpty())
            {
                ans = dq.pollFirst();
                ind--;
            }
            ind = K;
            while(ind!=0 && !dq.isEmpty())
            {
                ans = dq.pollLast();
                ind--;
            }
            ind = K;
        }
        return ans;
    }
}
