import java.io.*;
import java.lang.*;
import java.util.*;

class Job 
{
    int id, profit, deadline;
    Job(int x, int y, int z)
    {
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine().trim());
	while(t-->0)
	{
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            Solution ob = new Solution();
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class JobComparator implements Comparator<Job>
{
    public int compare(Job j1,Job j2){
        return j2.profit-j1.profit;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new JobComparator());
        
        int max_profit=0,tot_jobs=0;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline-1;j>=0;j--)
            {
                if(vis[j]==false)
                {
                    max_profit+=arr[i].profit;
                    tot_jobs+=1;
                    vis[j]=true;
                    break;
                }
            }
        }
        int []res={tot_jobs,max_profit};
        return res;
    }
}
