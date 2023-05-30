import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern)
    {
        ArrayList<String> list = new ArrayList<>();
        for (String str : Dictionary) 
        {
            String cmp = "";
            for (char ch : str.toCharArray()) 
            {
                if (ch >= 'A' && ch <= 'Z') 
                    cmp += ch;
                if (cmp.length() == Pattern.length()) 
                    break;
            }
            if (cmp.equals(Pattern)) 
                list.add(str);
        }
        Collections.sort(list);
        if (list.isEmpty()) 
            list.add("-1");
        return list;
    }
}
