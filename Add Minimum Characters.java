import java.io.*;
import java.util.*;

class Solution
{
    public static int addMinChar(String str)
    {
        String concatStr = str + "#" + new StringBuilder(str).reverse().toString();
        int[] lps = computeLPS(concatStr);
        return str.length() - lps[lps.length - 1];
    }

    private static int[] computeLPS(String str) 
    {
        int[] lps = new int[str.length()]; 
        int i = 1, j = 0; 
        while (i < str.length()) 
        { 
            if (str.charAt(i) == str.charAt(j)) 
            { 
                lps[i++] = ++j;
            }
            else 
            {
                if (j != 0) 
                    j = lps[j - 1]; 
                else 
                    lps[i++] = 0; 
            }
        }
        return lps; 
    }
}


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        } 
    }
}
