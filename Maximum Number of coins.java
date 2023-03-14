import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}

//User function Template for Java
class Solution{
    int dp[][];
    int maxCoins(int N, ArrayList<Integer> arr) {
		int[] a=new int[N+2];
		a[0]=1;
		a[N+1]=1;
		dp=new int[N+2][N+2];
		for(int i=0;i<N+2;i++){
		    for(int j=0;j<N+2;j++){
		        dp[i][j]=-1;
		    }
		}
		for(int i=1;i<N+1;i++){
		    a[i]=arr.get(i-1);
		}
		return solve(a,0,N+1);
	}
	
	int solve(int []a,int st,int end)
	{
	    if(end-st==1)
	    {
	        return 0;
	    }
	    if(dp[st][end]!=-1){
	        return dp[st][end];
	    }
	    int max=0;
	    for(int mid=st+1;mid<end;mid++){
	        int cur=a[st]*a[mid]*a[end]+solve(a,st,mid)+solve(a,mid,end);
	        max=Math.max(max,cur);
	    }
	    return dp[st][end]=max;
	}
}
