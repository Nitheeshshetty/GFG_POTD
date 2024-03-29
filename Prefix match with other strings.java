import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
                arr[i] = sc.next();
            int k = Integer.parseInt(sc.next());
            String str = sc.next();
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            t--;
        }
    }
}


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        int count=0;
        if(k>str.length())
            return count;
        CharSequence ch =str.subSequence(0,k);
        for(int i=0;i<n;i++)
        {
            if(arr[i].length()<k)
                continue;
            else if(arr[i].subSequence(0,k).equals(ch))
                count++;
        }
        return count;
    }
}
