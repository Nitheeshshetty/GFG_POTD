import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String [] args) throws IOException 
    {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int test = Integer.parseInt(br.readLine());
	while(test-- > 0) 
	{
	    int n = Integer.parseInt(br.readLine());
	    int [] arr = new int[n];
	    String [] str = br.readLine().trim().split(" ");
	    for(int i = 0; i < n; i++)
		arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
	    int n = arr.length;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int [] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++)
        {
            while (!left.empty() && arr[left.peek()] >= arr[i])
            {
                left.pop();
            }

            if (!left.empty())
            {
                res[i] = left.peek();
            }

            left.push(i);
        }

        for (int i = n - 1; i >= 0; i--)
        {
            while (!right.empty() && arr[right.peek()] >= arr[i])
            {
                right.pop();
            }

            if (!right.empty())
            {
                if (res[i] != -1)
                {
                    if (Math.abs(res[i] - i) == Math.abs(right.peek() - i))
                    {
                        if (arr[res[i]] > arr[right.peek()])
                            res[i] = right.peek();
                    }
                    else if (Math.abs(res[i] - i) > Math.abs(right.peek() - i))
                        res[i] = right.peek();
                }
                else
                    res[i] = right.peek();
            }

            right.push(i);
        }

        return res;
	}
}
