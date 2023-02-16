//{ Driver Code Starts

import java.io.*;
import java.util.*;

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution 
{
    static int ans=0;
    public static  boolean dfs(int[] arr,boolean[] vis,boolean[] loop,int n,int i)
    {
        if(i<0 || i>=n){
            return true;
        }
        if(vis[i]==true && loop[i]==false){
            return false;
        }
        if(vis[i]==true && loop[i]==true){
            return true;
        }
        vis[i]=true;
        if(dfs(arr,vis,loop,n,arr[i]+i)){
            ans++;
            loop[i]=true;
            return true;
        }
        return false;
    }
    
    public static int goodStones(int n, int[] arr) 
    {
        boolean[] vis=new boolean[n];
        boolean[] loop=new boolean[n];
        ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
               dfs(arr,vis,loop,n,i);
            }
        }
        return ans;
    }
}
        
