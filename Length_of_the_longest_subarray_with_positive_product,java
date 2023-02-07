//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
             arr[i] = Integer.parseInt(s[i]);
             
            out.println(new Solution().maxLength(arr, n)); 
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    /* Function to return the length of the
       longest subarray with ppositive product */
    int maxLength(int arr[], int n) { 
        //code here
        int pos=0;
        int neg=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==0)
                pos=neg=0;
            else if(arr[i]>0)
            {
                pos++;
                if(neg!=0)
                {
                    neg++;
                }
                ans=Math.max(pos,ans);
            }
            else{
                int temp=neg;
                neg=pos;
                pos=temp;
                neg++;
                if(pos!=0){
                    pos++;
                }
                ans=Math.max(pos,ans);
            }
            
        }
        return ans;
    }
   
}
