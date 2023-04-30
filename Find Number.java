import java.util.*;
import java.io.*;

class GFG 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0)
        {    
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}


class Solution
{
    public long findNumber(long N)
    {
        String s="";
        int []arr={1,3,5,7,9};
        while(N>0)
        {
            long cur=N%5;
            if(cur==0)
                s=arr[4]+s;
            else{
                s=arr[(int)cur-1]+s;
            }
            if(N%5==0 && N>0)
            {
                N=N/5-1;
            }
            else
            {
                N=N/5;
            }
        }
        return Long.parseLong(s);
    }
}
