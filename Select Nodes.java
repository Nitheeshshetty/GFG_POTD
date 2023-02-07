//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int[][]edge=new int[N-1][2];
            for(int i=0;i<N-1;i++)
            {
                String input[] = read.readLine().trim().split("\\s+");
                edge[i][0]=Integer.parseInt(input[0]);
                edge[i][1]=Integer.parseInt(input[1]);
            }
            Solution ob = new Solution();
            out.println(ob.countVertex(N, edge));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java

class Pair{
    int include, exclude;
    public Pair(int inc, int exc){
        include = inc;
        exclude = exc;
    }
}

class Solution{
    public int countVertex(int n, int[][] e){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<e.length;i++){
            adj.get(e[i][0]).add(e[i][1]);
            adj.get(e[i][1]).add(e[i][0]);
        }
        int x = Math.max(solve(1, -1, adj).include, solve(1, -1, adj).exclude);
        return n-x;
    }
    public Pair solve(int i, int parent, ArrayList<ArrayList<Integer>> adj){
        
        ArrayList<Pair> arr = new ArrayList<>();
        for(int neigh : adj.get(i)){
            if(parent!=neigh)
            arr.add(solve(neigh, i, adj));
        }
        
        int inc = 1, exc = 0;
        for(Pair p : arr){
            inc += p.exclude;
            exc += Math.max(p.include, p.exclude);
        }
        return new Pair(inc, exc);
    }
}
