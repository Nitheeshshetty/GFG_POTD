import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);  
		}
	}
}


//User function Template for Java
class Solution{
    public  static int specialPalindrome(String a, String b){
        int n1 = a.length(), n2 = b.length();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n1 - n2; i++) {
            int costs = 0;
            for (int k = 0; k < n2; k++) {
                if (a.charAt(i+k) != b.charAt(k)) {
                    costs += 1;
                }
            }
            int leftPtr = 0, rightPtr = n1 - 1;
            while (leftPtr < rightPtr) {
                if (i <= leftPtr && leftPtr < i+n2 && i <= rightPtr && rightPtr < i+n2 && b.charAt(leftPtr-i) != b.charAt(rightPtr-i)) 
                {
                    break;
                }
                char left = a.charAt(leftPtr);
                char right = a.charAt(rightPtr);
                if (i <= leftPtr && leftPtr < i+n2) {
                    left = b.charAt(leftPtr-i);
                }
                if (i <= rightPtr && rightPtr < i+n2) 
                {
                    right = b.charAt(rightPtr-i);
                }
                if (left != right) {
                    costs += 1;
                }
                leftPtr += 1;
                rightPtr -= 1;
            }
            if (leftPtr >= rightPtr) {
                ans = Math.min(ans, costs);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
