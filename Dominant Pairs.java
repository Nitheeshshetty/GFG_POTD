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

class GFG 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            int n;
            n = Integer.parseInt(br.readLine());
            int[] arr = IntArray.input(br, n);
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            System.out.println(res);
        }
    }
}


class Solution {
    public static int dominantPairs(int n, int[] arr) 
    {
        int j=n/2;
        int res=0;
        Arrays.sort(arr,0,j);
        Arrays.sort(arr,j,n);
        while(j<n)
        {
            int x=0,y=n/2-1;
            int ch=-1;
            while(x<=y)
            {
                int mid=(x+y)/2;
                if(arr[mid]>=5*arr[j])
                {
                    ch=mid;
                    y=mid-1;
                }
                else
                    x=mid+1;
            }
            if(ch!=-1)
                res+=n/2-ch;
            j++;
        }
        return res;
    }
}
        
