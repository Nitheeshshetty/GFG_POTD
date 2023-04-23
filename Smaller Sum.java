import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=Integer.parseInt(s[i]);
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans)
                out.print(i+" ");
            out.println();
        }
        out.close();
    }
}



class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        long ans[]=new long[n];
        long asc[]=new long[n];
        for(int i=0; i<n; i++)
            asc[i] = arr[i];
        Arrays.sort(asc);
        long p_sum[]=new long[n];
        p_sum[0]=asc[0];
        for(int i=1; i<n; i++)
            p_sum[i] = asc[i] + p_sum[i-1];
        for(int i=0; i<n; i++)
        {
            if(asc[0]==arr[i])
            {
                ans[i]=0;
                continue;
            }
            int l=0,r=n-1;
            while(l<r)
            {
                int mid=(l+r+1)/2;
                if(asc[mid]>=arr[i])
                    r=mid-1;
                else
                    l=mid;
            }
             ans[i]=p_sum[l];
        }
        return ans;
    }
}
