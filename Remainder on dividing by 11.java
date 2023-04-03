import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));         
        int t = Integer.parseInt(br.readLine()); 
        while(t > 0)
        {
            String x = br.readLine(); 
            Solution ob = new Solution();
            System.out.println(ob.xmod11(x)); 
            t--;
        }
    } 
} 


class Solution 
{ 
    static int xmod11(String x)
	  {    
	      int num=0;
        for(int i=0;i<x.length();i++)
        {
            num=(num*10)+(int)(x.charAt(i));
            num%=11;
        }
        return (num%11);
	  }
} 

