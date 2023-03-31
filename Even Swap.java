import java.io.*;
import java.lang.*;
import java.util.*;

class GFG
{
	 public static void main(String [] args) throws IOException
   {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int test = Integer.parseInt(br.readLine());
		  while(test-- > 0) {
			  int n = Integer.parseInt(br.readLine());
			  int [] arr = new int[n];
			  String [] str = br.readLine().trim().split(" ");
			  for(int i = 0; i < n; i++) {
				  arr[i] = Integer.parseInt(str[i]);
			  }
			  Solution obj = new Solution();
			  int [] b = obj.lexicographicallyLargest(arr, n);
			  for(int x: b) {
				  System.out.print(x+" ");
			  }
			  System.out.println();
		  }
	 }
}




class Solution
{
    int [] lexicographicallyLargest(int [] arr, int n) 
    {
        while(true){
            int cnt=0;
            for(int i=0;i<n-1;i++)
            {
                if((arr[i]+arr[i+1])%2==0 && arr[i+1]>arr[i])
                {
                    cnt++;
                    swap(arr,i,i+1);
                }
            }
            if(cnt==0)
                break;
        }
        return arr;    
    }
    
    public void swap(int[] arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
