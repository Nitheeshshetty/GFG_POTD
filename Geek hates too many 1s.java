//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        int num=1<<30;
        int count=0;
        while(num!=0)
        {
            if((n&num)==num) 
                count++;
            else
            {
                count=0;
            }
            if(count==3)
            {
                n=n-num;
                count=0;
            }
            num=num>>1;
        }
        return n;
    }
}
