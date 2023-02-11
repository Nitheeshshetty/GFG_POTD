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
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        int total_dep = 0;
        for(int i=0; i<N; i++)
        {
            if(i-1>=0)
            {
                if(S.charAt(i)==S.charAt(i-1)){
                    total_dep++;
                }
            }
            if(i+1<N)
            {
                if(S.charAt(i)==S.charAt(i+1)){
                    total_dep++;
                }
            }
        }
        if(total_dep==0) return 0;
        char arr[] = S.toCharArray();
        for(int day=0; day<N; day++)
        {
            int i = P[day];
            if(i-1>=0 && arr[i]==arr[i-1])
            {
                total_dep-=2;
            }
            if(i+1<N && arr[i]==arr[i+1])
            {
                total_dep-=2;
            }
            arr[i] = '?';
            if(total_dep==0) 
                return day+1;
        }
        return N;
    }
}
        
