import java.util.*;
import java.io.*;

class GFG 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) 
        {
            int n = Integer.parseInt(in.readLine());
            int arr[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            System.out.println(obj.LargButMinFreq(arr, n));
        }
    }
}

// Helper class to find largest number with minimum frequency
class Solution {
    public static int LargButMinFreq(int arr[], int n) {
         HashMap<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(Integer num : map.keySet()){
            if(map.get(num)<=min){
                min=map.get(num);
                max=Math.max(max,num);
            }
        }
        return max;
    }
}
