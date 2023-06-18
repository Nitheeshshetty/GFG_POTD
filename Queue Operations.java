import java.io.*;
import java.util.*;

class Geeks
{
    static void insert(Queue<Integer> q, int k)
    {
        q.add(k);
    }
	
    static int findFrequency(Queue<Integer> q, int k)
    {
        int freq = 0;
        int t = q.size();
        while(t-->0)
	{
            if(q.peek() == k){
                freq++;
            }
            q.add(q.remove());
        }
        return freq;
    }
}


class GFG 
{
    public static void main (String[] args) 
    {
	Scanner sc = new Scanner(System.in);
	int testcase = sc.nextInt();	
	while(testcase-- > 0)
	{
	    Queue<Integer> q = new LinkedList<>();
	    int n = sc.nextInt();
	    Geeks obj = new Geeks();
	    for(int i = 0;i<n;i++)
	    {
		int k = sc.nextInt();
		obj.insert(q, k);
	    }
		   
		    int x = sc.nextInt();
		    for(int i = 0;i<x;i++){
		        int k = sc.nextInt();
		        int f = obj.findFrequency(q, k);
		        if(f != 0){
		            System.out.println(f);
		        }
		        else{
		            System.out.println("-1");
		        }
		    }
		}
	}
}
// } Driver Code Ends
